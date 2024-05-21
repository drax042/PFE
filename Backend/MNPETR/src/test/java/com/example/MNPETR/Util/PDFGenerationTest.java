package com.example.MNPETR.Util;

import com.example.MNPETR.Model.OrdreDeTravail;
import com.example.MNPETR.Service.OrdreDeTravailService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PDFGenerationTest {

    @Autowired
    private OrdreDeTravailService ordreDeTravailService;

    @Test
    public void testPDFGeneration() {
        List<OrdreDeTravail> ordresDeTravail = ordreDeTravailService.getAllOrdreDeTravail();
        PDFGenerator pdfGenerator = new PDFGenerator();
        pdfGenerator.generatePDF(ordresDeTravail);
    }
}
