package testObject;

import org.testng.annotations.Test;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

public class ResultOfBusesSerachPageTest extends TestClass{
    static HashMap<Double,String> setOfBusNameAndBusPrice;
    static Double maxBusprice;
    static Double minBusPrice;


    @Test(priority=3)
    public void showingBusNameAndPrice() throws Exception {

        listOfBusAndPrice.fetchBusName();
        listOfBusAndPrice.fetchBusPrice();
        listOfBusAndPrice.applyFilters();
        System.out.println(listOfBusAndPrice.fetchBusName());
        System.out.println(listOfBusAndPrice.fetchBusPrice());
    }

    @Test(priority=4)
    public void compareBusName() throws Exception {
        listOfBusAndPrice.fetchBusName();
        dataObjectFromExcel.fetchDatafromExcel(0);


        for (int s=0; s<dataObjectFromExcel.fetchDatafromExcel(0).size();s++) 	{
            if (listOfBusAndPrice.fetchBusName().contains((dataObjectFromExcel.fetchDatafromExcel(0).get(s)))) {
                System.out.println("Bus Match");
            }else {
                System.out.println("Bus Not Match");
            }
        }
    }


//    @Test(priority=5)
    public void compareBusPrice() throws Exception {
        listOfBusAndPrice.fetchBusPrice();
        dataObjectFromExcel.fetchDatafromExcel(1);

        for (int i= 0; i<dataObjectFromExcel.fetchDatafromExcel(1).size(); i++) {
            if (listOfBusAndPrice.fetchBusName().contains(dataObjectFromExcel.fetchDatafromExcel(1).get(i))) {
                System.out.println("Price Match");
            }
            else {
                System.out.println("Price Not Match");
            }

        }


    }

//    @Test(priority=6)
    public HashMap<Double,String> makingSetOfBusNameAndBusPrice() {

        setOfBusNameAndBusPrice= new HashMap<Double, String>();
        for (int x=0; x<listOfBusAndPrice.fetchBusName().size();x++) {
            setOfBusNameAndBusPrice.put(listOfBusAndPrice.fetchBusPrice().get(x), listOfBusAndPrice.fetchBusName().get(x));
        }

        return setOfBusNameAndBusPrice;

    }

    @Test(priority=7)
    public void comparingMaxAndMinPrice() {
        maxBusprice= Collections.max(makingSetOfBusNameAndBusPrice().keySet());
        System.out.println(maxBusprice);
        minBusPrice= Collections.min(makingSetOfBusNameAndBusPrice().keySet());
        System.out.println(minBusPrice);

        System.out.println("MaxPrice:"+ maxBusprice+"Name of Bus:"+ makingSetOfBusNameAndBusPrice().get(maxBusprice));
        System.out.println("minPrice:"+ minBusPrice+"Name of Bus:"+ makingSetOfBusNameAndBusPrice().get(minBusPrice));
    }

    @Test(priority=8)
    public void compareBusNameByCollectionsLib() throws IOException {
        System.out.println(CollectionUtils.subtract(listOfBusAndPrice.fetchBusName(),dataObjectFromExcel.fetchDatafromExcel(0)));
    }





}
