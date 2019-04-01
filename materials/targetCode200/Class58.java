/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;

 

public class Class58 extends Class18 implements Class34 
{
    private Class59 state = null;
    public Class6 field176 = null;
    public Class190 field177 = null;

    public Class58(Class59 newState)
    {

        super();
        state = newState;

    }


    public Class58(int arg45)
    {

        super(arg45);
        field176 = new Class6();
        field177 = new Class190();

    }



    /**
     *  
     */
    public void request()
    {
        state.iMethod13(this);

    }

    /**
     * 
     * @param nextState 
     */
    public void updateState(Class59 nextState)
    {
        state = nextState;

    }

    /**
     * 
     * @param arg222 
     */
    public void method33(String arg222)
    {
    }

    /**
     *  
     */
    public void method147()
    {
    }

    /**
     *  
     */
    private void method312()
    {
        Class21 field874 = new Class21();
        field874.method311(808054);

    }

    /**
     *  
     */
    public void method314()
    {
        Class22 field875 = new Class22();
        field875.method313(0.10197908f);

    }

    /**
     *  
     */
    public void method316()
    {
        Class66 field876 = new Class66();
        field876.method315("WWW8YZ8UZ");

    }

    /**
     * 
     * @param arg649 
     */
    public void method977(double arg649)
    {
    }

    /**
     *  
     */
    @Override
    public void iMethod5()
    {
    }

    /**
     *  
     */
    @Override
    public void iMethod6()
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
    public Class42 iMethod10()
    {
        return new Class42();

    }
}