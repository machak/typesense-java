package org.typesense.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.typesense.model.DeleteDocumentsParameters;
import org.typesense.model.ExportDocumentsParameters;
import org.typesense.model.ImportDocumentsParameters;
import org.typesense.model.SearchParameters;

import junit.framework.TestCase;

public class DocumentsTest extends TestCase {

    private static final Logger log = LoggerFactory.getLogger(DocumentsTest.class);
    public TypesenseClient client;
    private Helper helper;

    public void setUp() throws Exception {
        super.setUp();
        helper = new Helper();
        this.client = helper.getClient();
        helper.createTestCollection();
    }

    public void tearDown() throws Exception {
        super.tearDown();
        helper.teardown();
    }

    public void testRetrieveDocument() throws Exception {
        helper.createTestDocument();
        log.debug(String.valueOf(client.collections("books").documents("1").retrieve()));
    }

    public void testCreateDocument() throws Exception {

        String[] authors = {"shakspeare", "william"};
        Map<String, Object> hmap = new HashMap<>();
        hmap.put("title", "Romeo and juliet");
        hmap.put("authors", authors);
        hmap.put("image_url", "fgfg");
        hmap.put("publication_year", 1666);
        hmap.put("ratings_count", 124);
        hmap.put("average_rating", 3.2);
        hmap.put("publication_year_facet", "dff");
        hmap.put("authors_facet", authors);
        hmap.put("id", "1");

        log.debug(String.valueOf(client.collections("books").documents().create(hmap)));
    }

    public void testUpsertDocument() throws Exception {

        String[] authors = new String[]{"jk", "Rowling"};
        HashMap<String, Object> hmap = new HashMap<>();
        hmap.put("title", "harry potter");
        hmap.put("authors", authors);
        hmap.put("image_url", "fgfg");
        hmap.put("publication_year", 2001);
        hmap.put("ratings_count", 231);
        hmap.put("average_rating", 5.6);
        hmap.put("publication_year_facet", "2001");
        hmap.put("authors_facet", authors);
        hmap.put("id", "3");

        log.debug(String.valueOf(client.collections("books").documents().upsert(hmap)));

    }

    public void testDeleteDocument() throws Exception {
        helper.createTestDocument();
        log.debug(String.valueOf(client.collections("books").documents("1").delete()));
    }

    public void testDeleteDocumentByQuery() throws Exception {
        helper.createTestDocument();
        DeleteDocumentsParameters deleteDocumentsParameters = new DeleteDocumentsParameters();
        deleteDocumentsParameters.filterBy("publication_year:=[1666]");
        deleteDocumentsParameters.batchSize(10);
        log.debug(String.valueOf(client.collections("books").documents().delete(deleteDocumentsParameters)));
    }

    public void testUpdateDocument() throws Exception {
        helper.createTestDocument();
        String[] authors = new String[]{"Shakespeare", "william"};
        HashMap<String, Object> document = new HashMap<>();
        document.put("title", "Romeo and juliet");
        document.put("authors", authors);
        document.put("id", "1");
        client.collections("books").documents("1").update(document);
        //log.debug(client.collections("books").documents("1").update(document));
    }

    public void testSearchDocuments() throws Exception {
        helper.createTestDocument();
        SearchParameters searchParameters = new SearchParameters()
                .q("romeo")
                .queryBy("title,authors")
                .prefix("false,true");
        org.typesense.model.SearchResult searchResult = client.collections("books").documents().search(searchParameters);

        log.debug(String.valueOf(searchResult));
    }

    public void testImport() throws Exception {
        Map<String, Object> document1 = new HashMap<>();
        Map<String, Object> document2 = new HashMap<>();
        ImportDocumentsParameters queryParameters = new ImportDocumentsParameters();
        List<Map<String, Object>> documentList = new ArrayList<>();

        document1.put("countryName", "India");
        document1.put("capital", "Delhi");
        document1.put("gdp", 23);
        document2.put("countryName", "Us");
        document2.put("capital", "Washington");
        document2.put("gdp", 233);

        documentList.add(document1);
        documentList.add(document2);

        queryParameters.action("create");
        log.debug(this.client.collections("books").documents().import_(documentList, queryParameters));
    }

    public void testImportAsString() throws Exception {
        ImportDocumentsParameters queryParameters = new ImportDocumentsParameters();
        queryParameters.action("create");
        String documentList = "{\"countryName\": \"India\", \"capital\": \"Washington\", \"gdp\": 5215}\n" +
                "{\"countryName\": \"Iran\", \"capital\": \"London\", \"gdp\": 5215}";
        log.debug(this.client.collections("books").documents().import_(documentList, queryParameters));
    }

    public void testExportDocuments() throws Exception {
        helper.createTestDocument();
        ExportDocumentsParameters exportDocumentsParameters = new ExportDocumentsParameters();
        exportDocumentsParameters.setExcludeFields("id,publication_year,authors");
        log.debug(client.collections("books").documents().export(exportDocumentsParameters));
    }

    public void testImportFromFile() throws FileNotFoundException, Exception {
        File myObj = new File("/tmp/books.jsonl");
        ImportDocumentsParameters queryParameters = new ImportDocumentsParameters();
        Scanner myReader = new Scanner(myObj);
        StringBuilder data = new StringBuilder();
        while (myReader.hasNextLine()) {
            data.append(myReader.nextLine()).append("\n");
        }
        client.collections("books").documents().import_(data.toString(), queryParameters);
    }

    public void testDirtyCreate() throws Exception {
        helper.createTestDocument();
        ImportDocumentsParameters queryParameters = new ImportDocumentsParameters();
        queryParameters.dirtyValues(ImportDocumentsParameters.DirtyValuesEnum.COERCE_OR_REJECT);
        queryParameters.action("upsert");
        String[] authors = {"shakspeare", "william"};
        HashMap<String, Object> hmap = new HashMap<>();
        hmap.put("title", 111);
        hmap.put("authors", authors);
        hmap.put("publication_year", 1666);
        hmap.put("ratings_count", 124);
        hmap.put("average_rating", 3.2);
        hmap.put("id", "2");

        log.debug(this.client.collections("books").documents().create(hmap, queryParameters));
    }
}
