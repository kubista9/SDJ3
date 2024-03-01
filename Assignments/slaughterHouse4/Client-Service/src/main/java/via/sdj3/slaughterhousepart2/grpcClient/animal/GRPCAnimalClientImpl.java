package via.sdj3.slaughterhousepart2.grpcClient.animal;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.springframework.stereotype.Service;
import via.sdj3.slaughterhousepart2.entity.Animal;
import via.sdj3.slaughterhousepart2.generated.animal.AnimalObj;
import via.sdj3.slaughterhousepart2.generated.animal.AnimalServiceGrpc;


@Service
public class GRPCAnimalClientImpl implements AnimalClient
{
    private AnimalServiceGrpc.AnimalServiceBlockingStub animalBlockingStub; //synchronous - abstracts the details of network communication

    public AnimalServiceGrpc.AnimalServiceBlockingStub getAnimalBlockingStub()
    {
        if (animalBlockingStub == null)
        {
            ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 25565).usePlaintext().build();
            animalBlockingStub = AnimalServiceGrpc.newBlockingStub(managedChannel); //proxy
        }
        return animalBlockingStub;
    }

    @Override
    public Animal addAnimal(Animal animal) {
        AnimalObj animalObj = AnimalObj.newBuilder().setId(animal.getAnimalId()).setName(animal.getName()).setDate(animal.getDateOfArrival()).setOrigin(animal.getPlaceOfOrigin()).setWeight(animal.getWeight()).build();
        AnimalObj animalObjFromServer;

        try
        {
            animalObjFromServer = getAnimalBlockingStub().addAnimal(animalObj);
        }
        catch (StatusRuntimeException sre)
        {
            System.out.println(sre.getStatus().getDescription());
            throw new RuntimeException(sre.getStatus().getDescription());
        }
        finally
        {
            animalBlockingStub = null;
        }

        System.out.println(animalObjFromServer.getName());
        Animal realObj = getAnimal(animalObjFromServer);
        System.out.println(realObj.getName());
        return realObj;
    }

    private Animal getAnimal(AnimalObj animalObjFromServer) {
        Animal returnedAnimal = new Animal();
        returnedAnimal.setAnimalId(animalObjFromServer.getId());
        returnedAnimal.setDateOfArrival(animalObjFromServer.getDate());
        returnedAnimal.setName(animalObjFromServer.getName());
        returnedAnimal.setPlaceOfOrigin(animalObjFromServer.getOrigin());
        returnedAnimal.setWeight(animalObjFromServer.getWeight());
        return returnedAnimal;
    }
}
