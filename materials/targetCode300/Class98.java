/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;

 

public class Class98 
{
    protected String description = null;
    private Class96 displayStrategy = null;
    private Class97 handleStrategy = null;
    private Class11 field749 = null;
    protected static Class193 field750 = null;

    public Class98()
    {

        displayStrategy = new Class99();
        handleStrategy = new Class100();

    }


    public Class98(Class97 handleBehavior, Class96 displayBehavior)
    {

        displayStrategy = displayBehavior;
        handleStrategy = handleBehavior;

    }


    public Class98(int arg74)
    {

        field749 = new Class11();
        field750 = new Class193();

    }



    /**
     *  
     */
    public void handleOperation()
    {
        displayStrategy.iMethod22(this);
        handleStrategy.iMethod24(displayStrategy);

    }

    /**
     *  
     */
    public String getDescription()
    {
        return description;

    }

    /**
     * 
     * @param val 
     */
    public void setValue(String val)
    {
        description = val;

    }

    /**
     * 
     * @param arg1049 
     */
    public void method51(boolean arg1049)
    {
    }

    /**
     * 
     * @param arg1472
     * @param arg1473 
     */
    public void method939(String arg1472, boolean arg1473)
    {
    }

    /**
     *  
     */
    public void method1161()
    {
    }

    /**
     *  
     */
    public void method1176()
    {
        Class130 field3285 = new Class130();
        field3285.method1175(false, 0.15353376f);

    }

    /**
     *  
     */
    public void method1178()
    {
        Class159 field3286 = new Class159();
        field3286.method1177(false);

    }

    /**
     *  
     */
    public void method1180()
    {
        Class164 field3287 = new Class164();
        field3287.method1179(false, 11915);

    }

    /**
     * 
     * @param arg1597 
     */
    public void method1182(Class94 arg1597)
    {
        Class191 field3288 = new Class191(arg1597);
        field3288.method1181(true);

    }

    /**
     *  
     */
    private void method1184()
    {
        Class226 field3289 = new Class226();
        field3289.method1183(true);

    }

    /**
     *  
     */
    private void method1186()
    {
        Class236 field3290 = new Class236();
        field3290.method1185("PJX4S7T");

    }

    /**
     *  
     */
    public void method1453()
    {
    }

    /**
     *  
     */
    public void method2233()
    {
    }

    /**
     * 
     * @param arg2338
     * @param arg2339 
     */
    public void method2659(int arg2338, int arg2339)
    {
    }

    /**
     * 
     * @param arg2348 
     */
    public void method2671(float arg2348)
    {
    }

    /**
     * 
     * @param arg2408
     * @param arg2409 
     */
    public void method2811(double arg2408, double arg2409)
    {
    }

    /**
     *  
     */
    public void method2943()
    {
    }

    /**
     * 
     * @param arg2665 
     */
    public void method3281(int arg2665)
    {
    }
}