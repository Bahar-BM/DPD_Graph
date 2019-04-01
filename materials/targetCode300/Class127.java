/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class127 implements Class5, Class67 
{
    private ArrayList<Class124> elementList = new ArrayList<Class124>();
    protected static Class4 field990 = null;
    protected static Class73 field991 = null;
    protected Class82 field992 = null;
    private static Class192 field993 = null;
    public Class229 field994 = null;

    public Class127()
    {

    }


    public Class127(int arg98)
    {

        field990 = new Class4();
        field991 = new Class73();
        field992 = new Class82();
        field993 = new Class192();
        field994 = new Class229();

    }



    /**
     * 
     * @param element 
     */
    public void attach(Class124 element)
    {
        elementList.add(element);

    }

    /**
     * 
     * @param element 
     */
    public void detach(Class124 element)
    {
        elementList.remove(element);

    }

    /**
     * 
     * @param visitor 
     */
    public void accept(Class121 visitor)
    {
        for ( int i = 0 ; i<elementList.size() ; i = i + 1 )
        {
            elementList.get(i).iMethod30(visitor);

        }

    }

    /**
     * 
     * @param arg1621 
     */
    public void method1225(String arg1621)
    {
    }

    /**
     * 
     * @param arg1682 
     */
    public void method1341(boolean arg1682)
    {
    }

    /**
     *  
     */
    public void method1546()
    {
        Class33 field3470 = new Class33();
        field3470.method1545(0.4355397223766204);

    }

    /**
     *  
     */
    public void method1548()
    {
        Class117 field3471 = new Class117();
        field3471.method1547("SEYE");

    }

    /**
     *  
     */
    protected void method1550()
    {
        Class130 field3472 = new Class130();
        field3472.method1549();

    }

    /**
     * 
     * @param arg1790 
     */
    public void method1552(Class173 arg1790)
    {
        Class285 field3473 = new Class285(arg1790);
        field3473.method1551();

    }

    /**
     * 
     * @param arg1901 
     */
    public void method1783(boolean arg1901)
    {
    }

    /**
     *  
     */
    public void method1835()
    {
    }

    /**
     * 
     * @param arg2204
     * @param arg2205 
     */
    public void method2405(float arg2204, boolean arg2205)
    {
    }

    /**
     * 
     * @param arg3160 
     */
    public void method4217(double arg3160)
    {
    }

    /**
     *  
     */
    @Override
    public Class7 iMethod2()
    {
        return new Class7();

    }

    /**
     *  
     */
    @Override
    public void iMethod17()
    {
    }
}