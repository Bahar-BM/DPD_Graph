/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class90 
{
    private ArrayList<Class87> elementList = new ArrayList<Class87>();
    private static Class23 field215 = null;
    protected Class99 field216 = null;
    public Class104 field217 = null;
    protected Class129 field218 = null;

    public Class90()
    {

    }


    public Class90(int arg69)
    {

        field215 = new Class23();
        field216 = new Class99();
        field217 = new Class104();
        field218 = new Class129();

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
    public void method153()
    {
    }

    /**
     *  
     */
    public void method324()
    {
        Class145 field565 = new Class145();
        field565.method323(0.7878035f);

    }

    /**
     * 
     * @param arg331 
     */
    public void method381(int arg331)
    {
    }

    /**
     * 
     * @param arg431 
     */
    public void method587(double arg431)
    {
    }
}