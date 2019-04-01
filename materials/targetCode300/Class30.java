/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class30 extends Class29 implements Class39, Class93 
{
    private ArrayList<Class29> componentList = new ArrayList<Class29>();
    public Class65 field221 = null;
    private static Class74 field222 = null;
    protected static Class112 field223 = null;
    public Class201 field224 = null;
    private static Class204 field225 = null;
    public Class274 field226 = null;
    public Class293 field228 = null;

    public Class30()
    {

        super(657978, null);

    }


    public Class30(int arg23, Class140 arg628, Class150 arg639)
    {

        super();
        field221 = new Class65();
        field222 = new Class74();
        field223 = new Class112();
        field224 = new Class201();
        field225 = new Class204();
        field226 = new Class274(this);
        field228 = new Class293(arg628);

    }



    /**
     *  
     */
    public void operation()
    {
        for ( int i = 0 ; i<componentList.size() ; i = i + 1 )
        {
            componentList.get(i).operation();

        }

    }

    /**
     * 
     * @param component 
     */
    public void attach(Class29 component)
    {
        componentList.add(component);

    }

    /**
     * 
     * @param component 
     */
    public void detach(Class29 component)
    {
        componentList.remove(component);

    }

    /**
     *  
     */
    public void method237()
    {
    }

    /**
     * 
     * @param arg1157 
     */
    public void method273(int arg1157)
    {
    }

    /**
     *  
     */
    protected void method344()
    {
        Class59 field2869 = new Class59();
        field2869.method343();

    }

    /**
     *  
     */
    protected void method346()
    {
        Class82 field2870 = new Class82();
        field2870.method345("V0HDN", true);

    }

    /**
     *  
     */
    protected void method348()
    {
        Class118 field2871 = new Class118();
        field2871.method347();

    }

    /**
     * 
     * @param arg1198 
     */
    protected void method350(Class41 arg1198)
    {
        Class178 field2872 = new Class178(arg1198);
        field2872.method349(0.0723145986565138);

    }

    /**
     * 
     * @param arg1200 
     */
    protected void method352(Class34 arg1200)
    {
        Class284 field2873 = new Class284(arg1200);
        field2873.method351(true);

    }

    /**
     *  
     */
    public void method354()
    {
        Class299 field2874 = new Class299();
        field2874.method353("AOUTCUO7S", false);

    }

    /**
     *  
     */
    public void method469()
    {
    }

    /**
     * 
     * @param arg1556
     * @param arg1557 
     */
    public void method1093(double arg1556, boolean arg1557)
    {
    }

    /**
     *  
     */
    public void method1111()
    {
    }

    /**
     * 
     * @param arg1883
     * @param arg1884 
     */
    public void method1743(float arg1883, String arg1884)
    {
    }

    /**
     *  
     */
    public void method2557()
    {
    }

    /**
     *  
     */
    public void method2617()
    {
    }

    /**
     * 
     * @param arg2395 
     */
    public void method2773(double arg2395)
    {
    }

    /**
     *  
     */
    public void method3367()
    {
    }

    /**
     *  
     */
    @Override
    public void iMethod9()
    {
    }

    /**
     *  
     */
    @Override
    public void iMethod21()
    {
    }
}