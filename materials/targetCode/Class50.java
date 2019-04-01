/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class50 extends Class21 
{
    private int state = 0;
    private ArrayList<Class51> observerList = new ArrayList<Class51>();
    protected Class60 field107 = null;
    protected static Class70 field108 = null;
    public Class90 field109 = null;
    public static Class110 field110 = null;
    protected static Class113 field111 = null;
    protected Class122 field112 = null;
    private Class127 field113 = null;

    public Class50()
    {

        super(161783);

    }


    public Class50(int arg37)
    {

        super();
        field107 = new Class60();
        field108 = new Class70();
        field109 = new Class90();
        field110 = new Class110();
        field111 = new Class113();
        field112 = new Class122();
        field113 = new Class127();

    }



    /**
     *  
     */
    public void notifyObservers()
    {
        for ( int i = 0 ; i<observerList.size() ; i = i + 1 )
        {
            observerList.get(i).update(this);

        }

    }

    /**
     * 
     * @param observer 
     */
    public void attach(Class51 observer)
    {
        observerList.add(observer);

    }

    /**
     * 
     * @param observer 
     */
    public void detach(Class51 observer)
    {
        observerList.remove(observer);

    }

    /**
     * 
     * @param newState 
     */
    public void setState(int newState)
    {
        state = newState;

    }

    /**
     *  
     */
    public int getState()
    {
        return state;

    }

    /**
     *  
     */
    public void method172()
    {
        Class35 field489 = new Class35();
        field489.method171(0.46207322904718096);

    }

    /**
     *  
     */
    private void method174()
    {
        Class97 field490 = new Class97();
        field490.method173(669905, 989259);

    }

    /**
     *  
     */
    public void method176()
    {
        Class102 field491 = new Class102();
        field491.method175();

    }

    /**
     *  
     */
    public void method531()
    {
    }
}