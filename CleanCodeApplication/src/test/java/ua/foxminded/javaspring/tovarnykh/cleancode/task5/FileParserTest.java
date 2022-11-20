package ua.foxminded.javaspring.tovarnykh.cleancode.task5;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import ua.foxminded.javaspring.tovarnykh.cleancode.task4.СharsСounter;

class FileParserTest {

    @Test
    void getStatistic_CommonArgument_True() {
	try {
	    assertEquals(
		    "{VBM=2018-05-24T12:00:00Z, SVF=2018-05-24T12:02:58.917Z, CSR=2018-05-24T12:03:15.145Z, DRR=2018-05-24T12:14:12.054Z, KMH=2018-05-24T12:02:51.003Z, SPF=2018-05-24T12:12:01.035Z, SVM=2018-05-24T12:18:37.735Z, CLS=2018-05-24T12:09:41.921Z, BHS=2018-05-24T12:14:51.985Z, LHM=2018-05-24T12:18:20.125Z, LSW=2018-05-24T12:06:13.511Z, RGH=2018-05-24T12:05:14.511Z, FAM=2018-05-24T12:13:04.512Z, SSW=2018-05-24T12:16:11.648Z, NHR=2018-05-24T12:02:49.914Z, MES=2018-05-24T12:04:45.513Z, EOF=2018-05-24T12:17:58.810Z, PGS=2018-05-24T12:07:23.645Z, KRF=2018-05-24T12:03:01.250Z}",
		    FileParser.getStatistic("src/test/resources/start.log").toString());
	} catch (IOException e) {
	    System.out.println("No access to file");
	}
    }

    @Test
    void getStatistic_BadArgument_True() {
	String answer = null;
	try {
	    FileParser.getStatistic("sometext");
	} catch (IOException e) {
	    answer = "Error";
	}
	assertNotNull(answer);
    }

    @Test
    void getAbbreviations_CommonArgument_True() {
	try {
	    assertEquals(
		    "{VBM=Valtteri Bottas_MERCEDES, SVF=Sebastian Vettel_FERRARI, CSR=Carlos Sainz_RENAULT, DRR=Daniel Ricciardo_RED BULL RACING TAG HEUER, KMH=Kevin Magnussen_HAAS FERRARI, SPF=Sergio Perez_FORCE INDIA MERCEDES, SVM=Stoffel Vandoorne_MCLAREN RENAULT, CLS=Charles Leclerc_SAUBER FERRARI, BHS=Brendon Hartley_SCUDERIA TORO ROSSO HONDA, LHM=Lewis Hamilton_MERCEDES, LSW=Lance Stroll_WILLIAMS MERCEDES, RGH=Romain Grosjean_HAAS FERRARI, FAM=Fernando Alonso_MCLAREN RENAULT, SSW=Sergey Sirotkin_WILLIAMS MERCEDES, NHR=Nico Hulkenberg_RENAULT, MES=Marcus Ericsson_SAUBER FERRARI, EOF=Esteban Ocon_FORCE INDIA MERCEDES, PGS=Pierre Gasly_SCUDERIA TORO ROSSO HONDA, KRF=Kimi Raikkonen_FERRARI}",
		    FileParser.getAbbreviations("src/test/resources/abbreviations.txt").toString());
	} catch (IOException e) {
	    System.out.println("No access to file");
	}
    }
    
    @Test
    void getAbbreviations() {
	String answer = null;
	try {
	    FileParser.getStatistic("sometext");
	} catch (IOException e) {
	    answer = "Error";
	}
	assertNotNull(answer);
    }

}
