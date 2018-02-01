package br.com.scorpion.poc.dao;

import br.com.scorpion.poc.model.Status;
import br.com.scorpion.poc.model.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class UsuarioDao {

    private MongoCollection<Document> usuariosCollection;

    private MongoDbConnection dbConnection;


    public UsuarioDao() {
        dbConnection = MongoDbConnection.getInstance();
        usuariosCollection = dbConnection.getDatabase().getCollection("usuarios");
    }

    public void inserir(Usuario usuario) {

        Document document = new Document("name", usuario.getEmailLogin());
        document.append("emailLogin", usuario.getEmailLogin());
        document.append("senha", usuario.getSenha().toString());
        document.append("status", usuario.getStatus().name());

        usuariosCollection.insertOne(document);

    }

    public void imprimirPrimeiro() {
        Document usuario = usuariosCollection.find().first();
        System.out.println(usuario.toJson());

    }


    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = new ArrayList<Usuario>();

        MongoCursor<Document> cursor = usuariosCollection.find().iterator();
        try {
            while (cursor.hasNext()) {
                //System.out.println(cursor.next().toJson());
                Document doc = cursor.next();
                Usuario u = new Usuario();
                u.setEmailLogin(doc.get("emailLogin").toString());
                u.setSenha(doc.getString("senha").toString());
                String strStatus = doc.get("status").toString();
                if (strStatus.equals(Status.ATIVO.name())) {
                    u.setStatus(Status.ATIVO);
                } else {
                    u.setStatus(Status.INATIVO);
                }

                usuarios.add(u);

            }
        } finally {
            cursor.close();
        }

        return usuarios;

    }

    public void excluir(String id) {
        DeleteResult deleteResult = usuariosCollection.deleteMany(eq("name", id));

        System.out.println(deleteResult.getDeletedCount() + " Excluídos");
    }

    public void excluirTodosAtivos() {
        DeleteResult deleteResult = usuariosCollection.deleteMany(eq("status", "INATIVO"));

        System.out.println(deleteResult.getDeletedCount());
    }


}
