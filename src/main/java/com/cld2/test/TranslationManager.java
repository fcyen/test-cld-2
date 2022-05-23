package com.cld2.test;

import com.hpe.caf.languagedetection.DetectedLanguage;
import com.hpe.caf.languagedetection.LanguageDetector;
import com.hpe.caf.languagedetection.LanguageDetectorException;
import com.hpe.caf.languagedetection.LanguageDetectorProvider;
import com.hpe.caf.languagedetection.LanguageDetectorResult;
import com.hpe.caf.languagedetection.LanguageDetectorSettings;
import com.hpe.caf.languagedetection.cld2.Cld2DetectorProvider;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TranslationManager {

  public static void main(String[] args) throws LanguageDetectorException {
    System.out.println("Hello World");
    LanguageDetectorProvider provider = new Cld2DetectorProvider();

    LanguageDetectorSettings settings = new LanguageDetectorSettings(false);
    /**
     * Detector implementation
     */
    LanguageDetector detector = provider.getLanguageDetector();

    /**
     * this is the final result from the language detection, and you pass in the bytes from the text file and settings
     */
    InputStream targetStream = new ByteArrayInputStream("风吹草低见牛羊".getBytes());
    LanguageDetectorResult result = detector.detectLanguage(targetStream, settings);

    DetectedLanguage[] d = result.getLanguages().toArray(new DetectedLanguage[result.getLanguages().size()]);

    /**
     * output the results
     */
    for (int i = 0; i < d.length; i++) {
      System.out.println("" + i + ": " + d[i].getLanguageCode());
      System.out.println("" + i + ": " + d[i].getLanguageName());
      System.out.println("" + i + ": " + d[i].getConfidencePercentage());
    }
//    Cld2Detector cld = new Cld2Detect();
//    Result detectedLanguage = cld.detect("风吹草低见牛羊");
//    System.out.println(detectedLanguage.getLanguageCode());
  }
}
