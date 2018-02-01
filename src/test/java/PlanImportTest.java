import br.com.scorpion.poc.xls_interpreter.PlanImport;
import org.junit.Test;

public class PlanImportTest {


   public void salvaPlanilhaNoMongoTest() {


        PlanImport importador = new PlanImport();

        importador.UploadPlanilha();


    }

    public void uploadPlanilhaTest() {
        PlanImport importador = new PlanImport();

        importador.UploadPlanilha();


    }


    public void lendoArquivosDisponiveisTest() {
        PlanImport importador = new PlanImport();

        importador.lendoArquivosNoBucket();


    }

    @Test
    public void downLoadAnSaveFilesTest() {
        PlanImport importador = new PlanImport();

        importador.downloadArquivos();


    }
}
