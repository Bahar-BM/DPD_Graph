/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;

 

public class Class69 
{
    protected String description = null;
    private Class67 displayStrategy = null;
    private Class68 handleStrategy = null;
    public Class63 field152 = null;
    protected Class47 field163 = null;
    protected static Class81 field164 = null;
    public static Class115 field165 = null;
    protected Class132 field166 = null;

    public Class69()
    {

        displayStrategy = new Class70();
        handleStrategy = new Class71();

    }


    public Class69(Class68 handleBehavior, Class67 displayBehavior)
    {

        displayStrategy = displayBehavior;
        handleStrategy = handleBehavior;

    }


    public Class69(int arg52, Class63 arg144, Class62 arg145)
    {

        field152 = arg144;
        field163 = new Class47();
        field164 = new Class81();
        field165 = new Class115(arg145);
        field166 = new Class132();

    }



    /**
     *  
     */
    public void handleOperation()
    {
        displayStrategy.iMethod15(this);
            handleStrategy.iMethod17(displayStrategy);

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
     * @param arg213 
     */
    public void method119(int arg213)
    {
    }

    /**
     *  
     */
    public void method242()
    {
        Class30 field524 = new Class30();
        field524.method241(0.2750137f);

    }

    /**
     * 
     * @param arg276 
     */
    protected void method244(Class59 arg276)
    {
        Class58 field525 = new Class58(arg276);
        field525.method243();

    }

    /**
     *  
     */
    public void method246()
    {
        Class101 field526 = new Class101();
        field526.method245(0.6652834f);

    }

    /**
     * 
     * @param arg288 
     */
    public void method271(float arg288)
    {
    }

    /**
     * 
     * @param arg381 
     */
    public void method471(float arg381)
    {
    }

    /**
     * 
     * @param arg419
     * @param arg420 
     */
    public void method561(String arg419, double arg420)
    {
    }

    /**
     * 
     * @param arg458 
     */
    public void method653(boolean arg458)
    {
    }
}