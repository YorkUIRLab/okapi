package org;

/**
 * Sadra
 * Created by Sadra on 1/19/16.
 */
public class OkapiTest {

    private static OkapiInterface okapiInterface = new OkapiImp();

    public static void main(String[] args) throws Exception {

        OkapiTest okapiTest = new OkapiTest();

        okapiTest.testSetDataBase("09article");
        okapiTest.testParseTerms("this and that");
        String stemmedKeyword = okapiTest.testStemTerm("surviving");
        String searchResult = okapiTest.testSearchTerm(stemmedKeyword);
      
        okapiTest.testGetWeigh(stemmedKeyword, searchResult);
        okapiTest.testDisplayResultSet();


        
    }

    private void testDisplayResultSet() {
        okapiInterface.displayResultSet();
    }

    private void testGetWeigh(String searchTerm, String searchResult) {
        okapiInterface.getWeigh(searchTerm,searchResult);
    }

    private String testSearchTerm(String searchTerm) {
        String response = okapiInterface.searchTerm(searchTerm);
        System.out.println(response);
        return response;
    }

    private void testSetDataBase(String dbName) {
        System.out.println("IN TEST");
    	String response = okapiInterface.setDatabase(dbName);
    	
    	System.out.println(response);
    	
    }

    private void testParseTerms(String parseTerms) {
        okapiInterface.parseTerms(parseTerms);
    }

    private String testStemTerm(String stemTerm) {
    	String response = okapiInterface.stemTerm(stemTerm);
    	System.out.println(response);
    	return response;
    }

}
