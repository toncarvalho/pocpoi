package br.com.scorpion.poc.dao;

import br.com.scorpion.poc.model.Status;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class UsuarioDao {

    private  MongoCollection<Document> usuariosCollection;

    public UsuarioDao() {

        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(connectionString);

        MongoDatabase database = mongoClient.getDatabase("mydb");

        usuariosCollection = database.getCollection("usuarios");


    }

    public  void inserir(){

        Document document = new Document("name","TON");
        document.append("emailLogin","toncarvalho@gmail.com");
        document.append("senha",123456);
        document.append("status",Status.ATIIVO.name());

        usuariosCollection.insertOne(document);

        Document d2 = new Document("name","rebeca");
        d2.append("emailLogin","rebecacarvalho@gmail.com");
        d2.append("senha",123456);
        d2.append("status",Status.ATIIVO.name());

        usuariosCollection.insertOne(d2);

    }



    public   void imprimirPrimeiro() {
        Document usuario = usuariosCollection.find().first();
        System.out.println(usuario.toJson());

    }

    public  void listarTodos() {

        MongoCursor<Document> cursor = usuariosCollection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }


    }

    public void excluir ( String id) {
        DeleteResult deleteResult = usuariosCollection.deleteMany(eq("name", id));

        System.out.println(deleteResult.getDeletedCount());
    }

}
