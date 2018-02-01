package br.com.scorpion.poc.xls_interpreter;

import br.com.scorpion.poc.dao.MongoDbConnection;
import com.mongodb.Block;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSUploadStream;
import com.mongodb.client.gridfs.model.GridFSDownloadOptions;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.io.*;

import static java.nio.file.Files.readAllBytes;

public class PlanImport {

    public void UpLoadForMongoAindaNaoTestado() {
        MongoDbConnection connection = MongoDbConnection.getInstance();
        MongoDatabase myDatabase = connection.getDatabase();


        // Create a gridFSBucket with a custom bucket name "files"
        GridFSBucket gridFSFilesBucket = GridFSBuckets.create(myDatabase, "files");

        // Get the input stream

        try {
            InputStream streamToUploadFrom = new FileInputStream(new File("/tmp/mongodb-tutorial.pdf"));
            // Create some custom options
            GridFSUploadOptions options = new GridFSUploadOptions()
                    .chunkSizeBytes(358400)
                    .metadata(new Document("type", "presentation"));

            ObjectId fileId = gridFSFilesBucket.uploadFromStream("mongodb-tutorial", streamToUploadFrom, options);
        } catch (FileNotFoundException e) {
            // handle exception
            e.printStackTrace();
        }


    }

    public void UploadPlanilha() {
        MongoDbConnection connection = MongoDbConnection.getInstance();
        MongoDatabase myDatabase = connection.getDatabase();


        // Create a gridFSBucket with a custom bucket name "files"
        GridFSBucket gridFSFilesBucket = GridFSBuckets.create(myDatabase, "files");

        // outro geito
        try {
            GridFSUploadOptions options = new GridFSUploadOptions().chunkSizeBytes(358400).metadata(new Document("type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));

            options.metadata(new Document("arquivo_importado", "json com informações extras"));

            GridFSUploadStream gridFSUploadStream = gridFSFilesBucket.openUploadStream("Sustentação 2017.xlsx", options);

            byte[] data = readAllBytes(new File("Sustentação 2017.xlsx").toPath());

            gridFSUploadStream.write(data);
            gridFSUploadStream.close();
            System.out.println("The fileId of the uploaded file is: " + gridFSUploadStream.getObjectId().toHexString());

        } catch (IOException e) {
            // handle exception
            e.printStackTrace();
        }

    }


    public void lendoArquivosNoBucket() {
        MongoDbConnection connection = MongoDbConnection.getInstance();
        MongoDatabase myDatabase = connection.getDatabase();

        GridFSBucket gridFSFilesBucket = GridFSBuckets.create(myDatabase, "files");

        gridFSFilesBucket.find().forEach(
                new Block<GridFSFile>() {
                    public void apply(final GridFSFile gridFSFile) {
                        System.out.println(gridFSFile.getFilename());
                    }
                });

    }

    public void downloadArquivos() {

        MongoDbConnection connection = MongoDbConnection.getInstance();
        MongoDatabase myDatabase = connection.getDatabase();

        GridFSBucket gridFSFilesBucket = GridFSBuckets.create(myDatabase, "files");

        gridFSFilesBucket.find().forEach(
                new Block<GridFSFile>() {
                    public void apply(final GridFSFile gridFSFile) {
                        System.out.println(gridFSFile.getFilename());

                        try {
                            FileOutputStream streamToDownloadTo = new FileOutputStream("C:\\Users\\Public\\Sustentação 2017.xlsx");
                            GridFSDownloadOptions downloadOptions = new GridFSDownloadOptions().revision(0);
                            gridFSFilesBucket.downloadToStream("Sustentação 2017.xlsx", streamToDownloadTo, downloadOptions);
                            streamToDownloadTo.close();
                        } catch (IOException e) {
                            // handle exception
                        }


                    }
                });


    }

}
