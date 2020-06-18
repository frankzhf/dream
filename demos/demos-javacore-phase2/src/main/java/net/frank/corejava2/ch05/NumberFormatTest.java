package net.frank.corejava2.ch05;


import net.frank.corejava2.GBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/***
 *  java.util.Locate
 *  Locale(String language)
 *  Locale(String language, String country)
 *  Locale(String language, String country, String variant)
 *  用给定的语言，国家和变量创建一个locate
 *
 *  static Locate getDefault()
 *  返回默认的locate
 *
 *  static void setDefault(Locate loc)
 *  设置默认的locate
 *
 *  String getDisplayName()
 *  String getDisplayName(Locate loc)
 *  返回显示名称
 *
 *  String getLanguage()
 *  String getLanguage(Locate loc)
 *  返回语言代码
 *
 *  String getCountry()
 *  返回国家代码
 *
 *  String getDisplayCountry()
 *  String getDisplayCountry(Locale loc)
 *  返回国家的显示名
 *
 *  String getVariant()
 *  返回变量字符串
 *
 *  String getDisplayVariant()
 *  String getDisplayVariant(Locate loc)
 *  返回变量名称
 *
 *  String toString()
 *  返回locate描述，包括语言国家和变量，用下划线分隔
 *
 *  java.awt.Applet
 *  Locale getLocate()
 *  得到Applet的locate对象
 *
 */

public class NumberFormatTest {

    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            JFrame frame = new NumberFormatFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}

class NumberFormatFrame extends JFrame {

    private Locale[] locales;
    private double currentNumber;
    private NumberFormat currentNumberFormat;

    private JComboBox<Locale> localeCombo = new JComboBox<>();
    private JButton parseButton  = new JButton("Parse");
    private JTextField numberText = new JTextField(30);
    private JRadioButton numberRadioButton = new JRadioButton("Number");
    private JRadioButton currencyRadioButton = new JRadioButton("Currency");
    private JRadioButton percentRadioButton = new JRadioButton("Percent");

    private ButtonGroup rbGroup = new ButtonGroup();


    public NumberFormatFrame(){
        setLayout(new GridBagLayout());
        setTitle("NumberFormatTest");

        ActionListener listener = e -> {
            updateDisplay();
        };

        JPanel p = new JPanel();
        addRadioButton(p,numberRadioButton,rbGroup,listener);
        addRadioButton(p,currencyRadioButton,rbGroup,listener);
        addRadioButton(p,percentRadioButton,rbGroup,listener);

        add(new JLabel("Locate"),new GBC(0,0).setInsets(GBC.EAST));
        add(p, new GBC(1,1));

        add(parseButton,new GBC(0,2).setInsets(2));
        add(localeCombo, new GBC(1,0).setAnchor(GBC.WEST));
        add(numberText,new GBC(1,2).setFill(GBC.HORIZONTAL));

        locales = NumberFormat.getAvailableLocales().clone();

        Arrays.sort(locales, Comparator.
                comparing(Locale::getDisplayName));

        for(Locale loc: locales){
            localeCombo.addItem(loc);
        }

        localeCombo.setSelectedItem(Locale.getDefault());
        currentNumber = 123456.78;
        updateDisplay();

        localeCombo.addActionListener(listener);
        parseButton.addActionListener(event -> {
            String s = numberText.getText().trim();
            try{
                Number n = currentNumberFormat.parse(s);
                if(n!=null){
                    currentNumber = n.doubleValue();
                    updateDisplay();
                }else{
                    numberText.setText("Parse error: " + s);
                }
            }catch (ParseException e){
                numberText.setText("Parse error: " + s);
            }
        });


        pack();


    }

    public void addRadioButton(Container p, JRadioButton b, ButtonGroup g, ActionListener listener){
        b.setSelected(g.getButtonCount() == 0);
        b.addActionListener(listener);
        g.add(b);
        p.add(b);
    }


    public void updateDisplay(){
        Locale currentLocale = locales[localeCombo.getSelectedIndex()];
        currentNumberFormat = null;
        if(numberRadioButton.isSelected()){
            currentNumberFormat = NumberFormat.getNumberInstance(currentLocale);
        }else if(currencyRadioButton.isSelected()){
            currentNumberFormat = NumberFormat.getCurrencyInstance(currentLocale);
        }else if(percentRadioButton.isSelected()){
            currentNumberFormat = NumberFormat.getPercentInstance(currentLocale);
        }
        String n = currentNumberFormat.format(currentNumber);
        numberText.setText(n);
    }

    /***
     * java.text.NumberFormat
     * static Locale[] getAvailableLocales()
     * 返回一个可通知的Locale数组
     *
     * static NumberFormat getNumberInstance()
     * static NumberFormat getNumberInstance(Locale l)
     * static NumberFormat getCurrencyInstance()
     * static NumberFormat getCurrencyInstance(Locale l)
     * static NumberFormat getPercentInstance()
     * static NumberFormat getPercentInstance(Locale l)
     * 为当前的或给定的locale提供数字、货币或百分比的格式器
     *
     * String format(double x)
     * String format(long x)
     * 格式化double或long,返回一个字符串
     *
     * Number parse(String s)
     * 解析一个字符串，返回一个数
     *
     * void setParseIntegerOnly(boolean b)
     * boolean getParseIntegerOnly()
     * 设置或获取一个标识，是否只解析整数值
     *
     * void setMinimumIntegerDigits(int n)
     * int getMinimumIntegerDigits()
     * void setMaximumIntegerDigits(int n)
     * int getMaximumIntegerDigits()
     * void setMinimumFactionDigits(int n)
     * int getMinimumFactionDigits()
     * void setMaximumFactionDigits(int n)
     * int getMaximumFactionDigits()
     * 设置或获取速数或小数部分所允许的最大或最小位数
     *
     * java.util.Currency
     * static Currency getInstance(String currencyCode)
     * static Currency getInstance(Locale locale)
     * 返回一个货币实例
     *
     * String toString()
     * String getCurrencyCode()
     * 获取货币代码
     *
     * String getSymbol()
     * String getSymbol(Locale locale)
     * 获取货币格式化符号
     *
     * int getDefaultFractionDigits()
     * 获取货币值小数点后的默认位数
     */


}
