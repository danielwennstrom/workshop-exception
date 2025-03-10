package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {
	public static void main(String[] args) {
        //TODO:

		List <String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        List <String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();
        List<String> lastNames;

        try {
            lastNames = CSVReader_Writer.getLastNames();
        }
        catch (IOException e) {
            System.err.println("IO error: " + e.getLocalizedMessage());
            lastNames = Collections.emptyList();
        }

        NameService nameService = new NameService(maleFirstNames, femaleFirstNames,lastNames);

        Person test = nameService.getNewRandomPerson();
        System.out.println(test);

        nameService.addLastName("Svenolofsson");
	}
}
