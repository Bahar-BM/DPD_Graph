/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class135 extends Class26 
{
    private ArrayList<Class132> elementList = new ArrayList<Class132>();
    public Class65 field464 = null;
    public Class19 field1038 = null;
    protected Class82 field1039 = null;
    private Class88 field1040 = null;
    private static Class106 field1041 = null;
    protected static Class210 field1042 = null;
    public Class231 field1043 = null;
    private Class264 field1044 = null;
    public Class270 field1045 = null;
    private static Class277 field1046 = null;
    protected Class280 field1047 = null;
    protected Class288 field1048 = null;
    public Class289 field1049 = null;
    protected Class296 field1051 = null;

    public Class135()
    {

        super(789256, null, null, null, null, null);

    }


    public Class135(int arg104, Class12 arg277, Class41 arg335, Class65 arg360, Class73 arg415, Class94 arg532, Class165 arg690, Class261 arg923)
    {

        super(arg104, arg277, arg335, arg415, arg532, arg690);
        field464 = arg360;
        field1038 = new Class19();
        field1039 = new Class82();
        field1040 = new Class88();
        field1041 = new Class106();
        field1042 = new Class210();
        field1043 = new Class231();
        field1044 = new Class264();
        field1045 = new Class270(arg923);
        field1046 = new Class277();
        field1047 = new Class280(arg690);
        field1048 = new Class288();
        field1049 = new Class289(this);
        field1051 = new Class296();

    }



    /**
     * 
     * @param element 
     */
    public void attach(Class132 element)
    {
        elementList.add(element);

    }

    /**
     * 
     * @param element 
     */
    public void detach(Class132 element)
    {
        elementList.remove(element);

    }

    /**
     * 
     * @param visitor 
     */
    public void accept(Class129 visitor)
    {
        for ( int i = 0 ; i<elementList.size() ; i = i + 1 )
        {
            elementList.get(i).iMethod33(visitor);

        }

    }

    /**
     * 
     * @param arg1243 
     */
    public void method455(String arg1243)
    {
    }

    /**
     * 
     * @param arg1411 
     */
    public void method825(boolean arg1411)
    {
    }

    /**
     * 
     * @param arg1603
     * @param arg1604 
     */
    public void method1193(double arg1603, int arg1604)
    {
    }

    /**
     *  
     */
    private void method1648()
    {
        Class10 field3521 = new Class10();
        field3521.method1647(0.37984645f);

    }

    /**
     * 
     * @param arg1838 
     */
    public void method1650(Class123 arg1838)
    {
        Class144 field3522 = new Class144(arg1838);
        field3522.method1649("", 813844);

    }

    /**
     *  
     */
    protected void method1652()
    {
        Class157 field3523 = new Class157();
        field3523.method1651(482363);

    }

    /**
     *  
     */
    protected void method1654()
    {
        Class206 field3524 = new Class206();
        field3524.method1653(0.9155624f);

    }

    /**
     *  
     */
    public void method1656()
    {
        Class237 field3525 = new Class237();
        field3525.method1655(false, 0.76451963f);

    }

    /**
     * 
     * @param arg1844 
     */
    protected void method1658(Class274 arg1844)
    {
        Class282 field3526 = new Class282(arg1844);
        field3526.method1657(770556);

    }

    /**
     * 
     * @param arg1929
     * @param arg1930 
     */
    public void method1837(float arg1929, int arg1930)
    {
    }

    /**
     * 
     * @param arg2994 
     */
    public void method3889(int arg2994)
    {
    }

    /**
     *  
     */
    @Override
    public void iMethod12()
    {
    }

    /**
     *  
     */
    @Override
    public void iMethod13()
    {
    }

    /**
     *  
     */
    @Override
    public void iMethod14()
    {
    }

    /**
     *  
     */
    @Override
    public void iMethod18()
    {
    }

    /**
     * 
     * @param context 
     */
    @Override
    public void iMethod19(Class83 context)
    {
    }

    /**
     *  
     */
    @Override
    public void iMethod25()
    {
    }
}