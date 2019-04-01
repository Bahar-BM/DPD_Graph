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
    protected Class4 field197 = null;
    public Class11 field198 = null;
    private Class101 field199 = null;

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


    public Class69(int arg52)
    {

        field197 = new Class4();
        field198 = new Class11();
        field199 = new Class101();

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
     * @param arg313
     * @param arg314 
     */
    public void method233(double arg313, int arg314)
    {
    }

    /**
     * 
     * @param arg356 
     */
    public void method323(float arg356)
    {
    }

    /**
     *  
     */
    private void method368()
    {
        Class20 field902 = new Class20();
        field902.method367(true);

    }

    /**
     *  
     */
    private void method370()
    {
        Class55 field903 = new Class55();
        field903.method369(0.1285798955260412);

    }

    /**
     *  
     */
    public void method372()
    {
        Class176 field904 = new Class176();
        field904.method371("2ICK25J", 0.5758865176483776);

    }

    /**
     *  
     */
    public void method561()
    {
    }

    /**
     * 
     * @param arg634
     * @param arg635 
     */
    public void method945(String arg634, boolean arg635)
    {
    }
}