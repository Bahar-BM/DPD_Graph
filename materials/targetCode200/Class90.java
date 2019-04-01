/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class90 extends Class18 
{
    private ArrayList<Class87> elementList = new ArrayList<Class87>();
    protected Class50 field269 = null;
    public Class90 field270 = null;
    protected Class101 field271 = null;
    protected Class102 field272 = null;
    public Class103 field273 = null;
    public Class116 field274 = null;
    public Class124 field275 = null;
    public Class132 field276 = null;

    public Class90()
    {

        super();

    }


    public Class90(int arg69)
    {

        super(arg69);
        field269 = new Class50();
        field270 = new Class90();
        field271 = new Class101();
        field272 = new Class102();
        field273 = new Class103();
        field274 = new Class116();
        field275 = new Class124();
        field276 = new Class132();

    }



    /**
     * 
     * @param element 
     */
    public void attach(Class87 element)
    {
        elementList.add(element);

    }

    /**
     * 
     * @param element 
     */
    public void detach(Class87 element)
    {
        elementList.remove(element);

    }

    /**
     * 
     * @param visitor 
     */
    public void accept(Class84 visitor)
    {
        for ( int i = 0 ; i<elementList.size() ; i = i + 1 )
        {
            elementList.get(i).iMethod22(visitor);

        }

    }

    /**
     *  
     */
    public void method466()
    {
        Class63 field951 = new Class63();
        field951.method465();

    }

    /**
     *  
     */
    protected void method468()
    {
        Class93 field952 = new Class93();
        field952.method467("6SLH");

    }

    /**
     *  
     */
    protected void method470()
    {
        Class97 field953 = new Class97();
        field953.method469(51126);

    }

    /**
     *  
     */
    public void method472()
    {
        Class128 field954 = new Class128();
        field954.method471("X04");

    }

    /**
     *  
     */
    protected void method474()
    {
        Class155 field955 = new Class155();
        field955.method473(143232);

    }

    /**
     *  
     */
    public void method476()
    {
        Class176 field956 = new Class176();
        field956.method475();

    }

    /**
     * 
     * @param arg471 
     */
    public void method565(boolean arg471)
    {
    }

    /**
     *  
     */
    public void method577()
    {
    }

    /**
     * 
     * @param arg483 
     */
    public void method593(int arg483)
    {
    }

    /**
     * 
     * @param arg558 
     */
    public void method771(String arg558)
    {
    }

    /**
     * 
     * @param arg583 
     */
    public void method845(String arg583)
    {
    }

    /**
     * 
     * @param arg657 
     */
    public void method1003(int arg657)
    {
    }
}