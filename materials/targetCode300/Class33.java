/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class33 extends Class32 implements Class89, Class132 
{
    private ArrayList<Class32> componentList = new ArrayList<Class32>();
    public Class26 field249 = null;
    public Class53 field250 = null;
    protected Class77 field251 = null;
    public Class87 field252 = null;
    private Class90 field253 = null;
    protected Class137 field254 = null;
    protected static Class138 field255 = null;
    private Class222 field256 = null;
    private Class250 field257 = null;
    private static Class271 field258 = null;
    public Class281 field259 = null;

    public Class33()
    {

        super();

    }


    public Class33(int arg26, Class41 arg311, Class73 arg435, Class165 arg694, Class178 arg753, Class218 arg860)
    {

        super(arg26, arg311, arg435, arg694);
        field249 = new Class26();
        field250 = new Class53();
        field251 = new Class77();
        field252 = new Class87();
        field253 = new Class90();
        field254 = new Class137();
        field255 = new Class138();
        field256 = new Class222(arg753, arg860);
        field257 = new Class250();
        field258 = new Class271();
        field259 = new Class281();

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
    public void attach(Class32 component)
    {
        componentList.add(component);

    }

    /**
     * 
     * @param component 
     */
    public void detach(Class32 component)
    {
        componentList.remove(component);

    }

    /**
     * 
     * @param arg1148 
     */
    public void method255(boolean arg1148)
    {
    }

    /**
     * 
     * @param arg1169 
     */
    public void method297(boolean arg1169)
    {
    }

    /**
     *  
     */
    public void method394()
    {
        Class8 field2894 = new Class8();
        field2894.method393("6YCY", 0.7858831018756595);

    }

    /**
     *  
     */
    private void method396()
    {
        Class20 field2895 = new Class20();
        field2895.method395(true, true);

    }

    /**
     *  
     */
    protected void method398()
    {
        Class68 field2896 = new Class68();
        field2896.method397();

    }

    /**
     *  
     */
    public void method400()
    {
        Class155 field2897 = new Class155();
        field2897.method399();

    }

    /**
     *  
     */
    public void method402()
    {
        Class172 field2898 = new Class172();
        field2898.method401();

    }

    /**
     * 
     * @param arg1223 
     */
    protected void method404(Class57 arg1223)
    {
        Class190 field2899 = new Class190(arg1223);
        field2899.method403(410156);

    }

    /**
     *  
     */
    public void method406()
    {
        Class192 field2900 = new Class192();
        field2900.method405();

    }

    /**
     *  
     */
    public void method408()
    {
        Class205 field2901 = new Class205();
        field2901.method407("2X");

    }

    /**
     *  
     */
    private void method410()
    {
        Class211 field2902 = new Class211();
        field2902.method409(false);

    }

    /**
     * 
     * @param arg1226 
     */
    protected void method412(Class150 arg1226)
    {
        Class233 field2903 = new Class233(arg1226);
        field2903.method411();

    }

    /**
     * 
     * @param arg1227 
     */
    private void method414(Class113 arg1227)
    {
        Class246 field2904 = new Class246(arg1227);
        field2904.method413();

    }

    /**
     * 
     * @param arg1463 
     */
    public void method923(int arg1463)
    {
    }

    /**
     *  
     */
    public void method1079()
    {
    }

    /**
     * 
     * @param arg1788 
     */
    public void method1545(double arg1788)
    {
    }

    /**
     * 
     * @param arg1845 
     */
    public void method1661(float arg1845)
    {
    }

    /**
     * 
     * @param arg2862
     * @param arg2863 
     */
    public void method3657(float arg2862, double arg2863)
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
    public void iMethod20()
    {
    }

    /**
     *  
     */
    @Override
    public void iMethod25()
    {
    }

    /**
     * 
     * @param in 
     */
    @Override
    public void iMethod33(Class129 in)
    {
    }
}