package org;

/**
 * Sadrayan
 * Created by Sadra on 1/19/16.
 */
public class OkapiImp implements OkapiInterface {

    public  javokapi okapi;  //CREATES NEW INSTANCE OF JAVOKAPI
    public  OkapiUtils okapiUtils; 
    public OkapiImp() {

        System.out.println("in constructor ");
        
    	okapi = new javokapi();  //CREATES NEW INSTANCE OF JAVOKAPI
        okapiUtils = new OkapiUtils();
    }

    @Override
    public String listDatabase() {
    	System.out.println("in list Database...");
        String dbList = okapi.infoDB();
        System.out.println("Listing Available Databases:" +dbList); //OUTPUTS THE AVAILABLE DATABASES
        return dbList;
    }

    @Override
    public String setDatabase(String dbName) {
        System.out.println("DB name: " + dbName);
        System.out.println(okapi.displayStemFunctions());
        okapi.chooseDB(dbName); //CHOOSE THE DATABASE UESR INPUTTED
        okapi.deleteAllSets(); //CLEAR ALL EXISTING DATASETS IF ANY
        return "database name successfully set to " + dbName;
    }

    @Override
    public String parseTerms(String parseTerms) {
        String okapiParsedTerms = okapi.superParse("", parseTerms);
        System.out.println("Parsed term(s): " + okapiParsedTerms);  //OUTPUT THE PARSED TERMS
        return "parsed terms: " + okapiParsedTerms;
    }

    @Override
    public String stemTerm(String term) {
        String stemmedWord = okapi.stem("psstem", term); //FINDS THE ROOT OF THE WORD (i.e. 'running' becomes 'run')
        System.out.println("Stemmed word: " + stemmedWord);
        return stemmedWord.replace("t=", "");  //Trims the t= produced from the stem() function
    }

    @Override
    public String searchTerm(String term) {
        String searchResult = okapi.find("1", "0", "DEFAULT", term); //QUERIES OKAPI WITH THE SEARCH WORD ENTERED BY USER
        System.out.println("search result: " + searchResult);
        return searchResult;
    }

    @Override
    public String displayResultSet() {
        System.out.println("Your query returned the following results");
        String results = "";

        for (int i = 0; i < 99; i++) {
            results = okapi.showSetRecord("1", "1", Integer.toString(i), "0") + ", ";
        }

        System.out.println("Record #" + results);
        return results;
    }

    @Override
    public String getWeigh(String term, String searchResult) {
        String np = okapiUtils.findNP(searchResult, term);  //SEE METHOD findNP() BELOW
        int npInt = Integer.parseInt(np);

        String weight = okapi.weight("2", np, "0", "0", "4", "5");
        System.out.println("weight()= " + weight);  //OUTPUT THE WEIGHT FOUND BY THE weight() FUNCTION
        System.out.println("setFind()= " + okapi.setFind("0", weight, "")); //OUTPUT THE SET
        System.out.println(okapi.displayStemFunctions());
        return weight;
    }
}
