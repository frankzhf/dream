package net.frank.corejava2.ch05;

import net.frank.corejava2.GBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Collator;
import java.util.*;
import java.util.List;

public class CollationTest {

    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            JFrame frame = new CollationFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}

class CollationFrame extends JFrame{

    private List<String> strings = new ArrayList<>();
    private Collator currentCollator;
    private Locale[] locales;
    private JComboBox<Locale> localeCombo = new JComboBox();
    private EnumCombo strengthCombo = new EnumCombo(Collator.class,new String[]{"Primary",
            "Secondary","Tertiary","Identical"});

    private EnumCombo decompositionCombo = new EnumCombo(Collator.class, new String[]{
            "Canonical Decomposition","Full Decomposition","No Decomposition"});

    private JTextField newWord = new JTextField(20);
    private JTextArea sortedWords = new JTextArea(20,20);
    private JButton addButton = new JButton("Add");

    public CollationFrame(){
        setTitle("CollationTest");
        setLayout(new GridBagLayout());
        add(new JLabel("Locale"), new GBC(0,0).setAnchor(GBC.EAST));
        add(new JLabel("Strength"), new GBC(0,1).setAnchor(GBC.EAST));
        add(new JLabel("Decomposition"), new GBC(0,2).setAnchor(GBC.EAST));

        add(addButton,new GBC(0,3).setAnchor(GBC.EAST));
        add(localeCombo,new GBC(1,0).setAnchor(GBC.WEST));
        add(strengthCombo,new GBC(1,1).setAnchor(GBC.WEST));
        add(decompositionCombo,new GBC(1,2).setAnchor(GBC.WEST));
        add(newWord,new GBC(1,3).setFill(GBC.HORIZONTAL));
        add(new JScrollPane(sortedWords),new GBC(0,4,2,1).setFill(GBC.BOTH));

        locales = Collator.getAvailableLocales();
        final Collator collator = Collator.getInstance(Locale.getDefault());
        Arrays.sort(locales, (o1, o2) -> collator.compare(o1.getDisplayName(),o2.getDisplayName()));

        for(Locale locale:locales){
            localeCombo.addItem(locale);
        }
        localeCombo.setSelectedItem(Locale.getDefault());

        strings.add("America");
        strings.add("able");
        strings.add("Zulu");
        strings.add("zebra");
        strings.add("\u00C5ngstr\u00F6m");
        strings.add("A\u030angstro\u0308m");
        strings.add("Angstrom");
        strings.add("Able");
        strings.add("office");
        strings.add("o\uF803ce");
        strings.add("java\u2112");
        strings.add("javaTM");
        updateDisplay();
        addButton.addActionListener(event->{
            strings.add(newWord.getText());
            updateDisplay();
        });

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDisplay();
            }
        };

        localeCombo.addActionListener(listener);
        strengthCombo.addActionListener(listener);
        decompositionCombo.addActionListener(listener);
        pack();

    }

    public void updateDisplay(){
        Locale currentLocale = locales[localeCombo.getSelectedIndex()];
        localeCombo.setLocale(currentLocale);

        currentCollator = Collator.getInstance(currentLocale);
        currentCollator.setStrength(strengthCombo.getValue());
        currentCollator.setDecomposition(decompositionCombo.getValue());

        Collections.sort(strings, currentCollator);

        sortedWords.setText("");

        for(int i=0;i<strings.size();i++){
            String s = strings.get(i);
            if(i> 0 && currentCollator.compare(s,strings.get(i-1)) == 0 ){
                sortedWords.append("= ");
            }
            sortedWords.append(s + "\n");
        }
        pack();
    }

    /**
     * java.text.MessageFormat
     * MessageFormat(String pattern)
     * MessageFormat(String pattern, Locale loc)
     * 用给定的模式和locale构建一个消息格式对象
     *
     * void applyPattern(String pattern)
     * 给消息格式对象设置物定的模式
     *
     * void setLocale(Locale loc)
     * Locale getLocale()
     * 设置或获取消息中占位符所使用的locale对象
     *
     * static String format(String pattern, Object... args)
     * 通过使用args[i]作为站位符[i]的输入来格化式pattern字符串
     *
     * StringBuffer format(Object args, StringBuffer result, FiledPosition pos)
     * 格式化MessageFormat的模式。args必须是一个对象数组。被格式化的字符串会被附加到result末尾,并返回result。如果pos等于new FieldPosition(MessageFormat.Field.ARGUMENT),就用它的biginIndex和endIndex属性值来设置替换占位符{1}的文本位置。如果不关心位置信息， 可以将它设为null
     *
     * java.text.Format
     * String format(Object ojb)
     * 按照格式器的规则格式化给定的对象，这个方法将调用format(obj, new StringBuffer(), new FieldPosition(1)).toString()
     *
     *
     * java.util.ResourceBundle
     * static ResourceBundle getBundle(String baseName, Locale loc)
     * static ResourceBundle getBundle(String baseName)
     * 在给定的locale或默认的locale下以给定的名字加载资源绑定类和它的父类，资源包类必须是public的。
     *
     * Object getObject(String name)
     * 从资源包或它的父包中查找一个对象
     *
     * String getString(String name)
     * 从资源包或它的父包中查找一对象并把它转型成字符串
     *
     * String[] getStringArray(String name)
     * 从资源包或它的父包中查找一对象并把它转型成字符串数组
     *
     * Enumeration<String> getKeys()
     * 返回一个枚举对象，枚举出资源包中所有键，也包括父包中的键
     *
     * Object handleGetObject(String key)
     * 如果你定义了自己的资源查找机制，这个方法需要被覆写，用来查找给定的键相关联的资源值
     *
     */

}
