/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class36 implements Class35 
{
    private ArrayList<Class35> componentList = new ArrayList<Class35>();
    public Class28 field274 = null;
    private Class70 field275 = null;
    public Class125 field276 = null;
    protected Class149 field277 = null;
    private Class159 field278 = null;
    private static Class171 field279 = null;
    private static Class200 field280 = null;
    public Class285 field281 = null;
    public static Class289 field282 = null;

    public Class36()
    {

    }


    public Class36(int arg28, Class135 arg615, Class173 arg734)
    {

        field274 = new Class28();
        field275 = new Class70();
        field276 = new Class125();
        field277 = new Class149();
        field278 = new Class159();
        field279 = new Class171();
        field280 = new Class200();
        field281 = new Class285(arg734);
        field282 = new Class289(arg615);

    }



    /**
     *  
     */
    public void iMethod8()
    {
        for ( int i = 0 ; i<componentList.size() ; i = i + 1 )
        {
            componentList.get(i).iMethod8();

        }

    }

    /**
     * 
     * @param component 
     */
    public void attach(Class35 component)
    {
        componentList.add(component);

    }

    /**
     * 
     * @param component 
     */
    public void detach(Class35 component)
    {
        componentList.remove(component);

    }

    /**
     * 
     * @param arg1104
     * @param arg1105 
     */
    public void method171(int arg1104, boolean arg1105)
    {
    }

    /**
     *  
     */
    public void method371()
    {
    }

    /**
     * 
     * @param arg1228 
     */
    public void method415(float arg1228)
    {
    }

    /**
     *  
     */
    protected void method428()
    {
        Class50 field2911 = new Class50();
        field2911.method427();

    }

    /**
     *  
     */
    public void method430()
    {
        Class110 field2912 = new Class110();
        field2912.method429();

    }

    /**
     * 
     * @param arg1234 
     */
    protected void method432(Class41 arg1234)
    {
        Class178 field2913 = new Class178(arg1234);
        field2913.method431();

    }

    /**
     *  
     */
    protected void method434()
    {
        Class199 field2914 = new Class199();
        field2914.method433(0.25705624820021555, 0.5292477f);

    }

    /**
     *  
     */
    public void method436()
    {
        Class221 field2915 = new Class221();
        field2915.method435("9GWMN7");

    }

    /**
     *  
     */
    public void method1095()
    {
    }

    /**
     *  
     */
    public void method1127()
    {
    }

    /**
     * 
     * @param arg1700 
     */
    public void method1381(String arg1700)
    {
    }

    /**
     * 
     * @param arg2269 
     */
    public void method2537(float arg2269)
    {
    }

    /**
     * 
     * @param arg2926 
     */
    public void method3759(String arg2926)
    {
    }
}