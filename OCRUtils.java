import java.io.File;
import java.lang.System.LoggerFinder;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OCRUtils {

    private static final Logger logger = LoggerFactory.getLogger(OCRUtils.class);
    private static String DATA_PATH;

    static final String URL = "/Users/blake/Downloads";
    private static String DEFAULT_LANG;

    public static String doOCRFromFile(File imageFile, String lang) throws TesseractException {
        ITesseract instance = new Tesseract();
        instance.setDatapath(getDataPath()); // 학습 데이터 ...
        instance.setTessVariable("user_defined_dpi", "300");
        instance.setLanguage(lang);
        return instance.doOCR(imageFile);
    }

    /**
     * main method
     */
    public static void main(String[] args) {
        //SpringApplication.run(OxOcrApp.class, args); //测试不用启用springboot

        logger.info("OxOcrApp 가동됨!");

        //트레이닝 데이터 위치
        OCRUtils.setDataPath("/usr/local/share/tessdata/"); // 현재 로컬에는 영 , 한 ,중국어만 있음.
        OCRUtils.setDefaultLang("kor"); //eng ：영문  chi_sim ：중국어 kor: 한국어

        String ocrText = null; //指定要识别的图片文件
        try {
            ocrText = OCRUtils.doOCRFromFile(new File(URL + "/2.png"), "kor");
            logger.info("인식된 텍스트：{}", ocrText);//OCR 결과：이미지 to  글자
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format(e.toString()));
        }
    }

    public static String getDataPath() {
        return DATA_PATH;
    }

    public static void setDataPath(String dataPath) {
        DATA_PATH = dataPath;
    }

    public static String getDefaultLang() {
        return DEFAULT_LANG;
    }

    public static void setDefaultLang(String defaultLang) {
        DEFAULT_LANG = defaultLang;
    }
}
