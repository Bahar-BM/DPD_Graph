/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class40 implements Class39 
{
    private ArrayList<Class39> componentList = new ArrayList<Class39>();
    private Class11 field300 = null;
    protected Class30 field301 = null;
    protected Class66 field302 = null;
    protected Class108 field303 = null;
    protected Class149 field304 = null;
    protected static Class193 field305 = null;
    private static Class218 field306 = null;
    public static Class226 field307 = null;
    private Class250 field308 = null;
    private Class251 field309 = null;
    private Class259 field310 = null;
    public Class271 field311 = null;
    protected Class294 field312 = null;

    public Class40()
    {

    }


    public Class40(int arg31, Class63 arg359, Class109 arg578, Class128 arg608)
    {

        field300 = new Class11();
        field301 = new Class30();
        field302 = new Class66();
        field303 = new Class108();
        field304 = new Class149();
        field305 = new Class193();
        field306 = new Class218();
        field307 = new Class226();
        field308 = new Class250();
        field309 = new Class251(arg608);
        field310 = new Class259(arg578);
        field311 = new Class271();
        field312 = new Class294(arg359);

    }



    /**
     *  
     */
    public void iMethod9()
    {
        for ( int i = 0 ; i<componentList.size() ; i = i + 1 )
        {
            componentList.get(i).iMethod9();

        }

    }

    /**
     * 
     * @param component 
     */
    public void attach(Class39 component)
    {
        componentList.add(component);

    }

    /**
     * 
     * @param component 
     */
    public void detach(Class39 component)
    {
        componentList.remove(component);

    }

    /**
     * 
     * @param arg1185 
     */
    public void method325(float arg1185)
    {
    }

    /**
     *  
     */
    public void method468()
    {
        Class22 field2931 = new Class22();
        field2931.method467(0.4043548347623438, 0.8394649692186856);

    }

    /**
     *  
     */
    public void method470()
    {
        Class30 field2932 = new Class30();
        field2932.method469();

    }

    /**
     *  
     */
    private void method472()
    {
        Class150 field2933 = new Class150();
        field2933.method471(0.1184104252379975, "HLN");

    }

    /**
     * 
     * @param arg1257 
     */
    protected void method474(Class140 arg1257)
    {
        Class219 field2934 = new Class219(arg1257);
        field2934.method473(0.08835292f);

    }

    /**
     *  
     */
    public void method476()
    {
        Class240 field2935 = new Class240();
        field2935.method475();

    }

    /**
     *  
     */
    protected void method478()
    {
        Class248 field2936 = new Class248();
        field2936.method477(0.21354427601667947, true);

    }

    /**
     *  
     */
    protected void method480()
    {
        Class255 field2937 = new Class255();
        field2937.method479();

    }

    /**
     *  
     */
    public void method482()
    {
        Class279 field2938 = new Class279();
        field2938.method481("ZD9");

    }

    /**
     *  
     */
    private void method484()
    {
        Class287 field2939 = new Class287();
        field2939.method483(0.5139290693695746);

    }

    /**
     * 
     * @param arg1600 
     */
    public void method1189(boolean arg1600)
    {
    }

    /**
     * 
     * @param arg1810 
     */
    public void method1595(int arg1810)
    {
    }

    /**
     * 
     * @param arg2154
     * @param arg2155 
     */
    public void method2303(String arg2154, boolean arg2155)
    {
    }

    /**
     *  
     */
    public void method2825()
    {
    }

    /**
     * 
     * @param arg2579 
     */
    public void method3119(String arg2579)
    {
    }

    /**
     * 
     * @param arg2946
     * @param arg2947 
     */
    public void method3801(boolean arg2946, double arg2947)
    {
    }

    /**
     * 
     * @param arg3029 
     */
    public void method3943(boolean arg3029)
    {
    }

    /**
     * 
     * @param arg3148
     * @param arg3149 
     */
    public void method4175(String arg3148, float arg3149)
    {
    }
}