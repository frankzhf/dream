package net.frank.corejava2.ch05;

import net.frank.corejava2.GBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

public class DateFormatTest {


    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            JFrame frame = new DateFormatFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class DateFormatFrame extends JFrame{

    private Locale[] locales;
    private Date currentDate;
    private Date currentTime;
    private DateFormat currentDateFormat;
    private DateFormat currentTimeFormat;
    private JComboBox<Locale> localeCombo = new JComboBox<>();
    private EnumCombo dateStyleCombo = new EnumCombo(DateFormat.class,
            new String[]{"Default","Full","Long","Medium","Short"});

    private EnumCombo timeStyleCombo = new EnumCombo(DateFormat.class,
            new String[]{"Default","Full","Long","Medium","Short"});

    private JButton dateParseButton = new JButton("Parse date");
    private JButton timeParseButton = new JButton("Parse time");

    private JTextField dateText = new JTextField(30);
    private JTextField timeText = new JTextField(30);

    private JCheckBox lenientCheckbox = new JCheckBox("Parse lenient",true);


    public DateFormatFrame(){
        setTitle("DateFormatTest");
        setLayout(new GridBagLayout());
        add(new JLabel("Locale"), new GBC(0,0).setAnchor(GBC.EAST));
        add(new JLabel("Date Style"), new GBC(0,1).setAnchor(GBC.EAST));
        add(new JLabel("Time Style"), new GBC(2,1).setAnchor(GBC.EAST));
        add(new JLabel("Date"), new GBC(0,2).setAnchor(GBC.EAST));
        add(new JLabel("Time"), new GBC(0,3).setAnchor(GBC.EAST));

        add(localeCombo,new GBC(1,0,2,1).setAnchor(GBC.WEST));
        add(dateStyleCombo, new GBC(1,1).setAnchor(GBC.WEST));
        add(timeStyleCombo,new GBC(3,1).setAnchor(GBC.WEST));
        add(dateParseButton,new GBC(3,2).setAnchor(GBC.WEST));
        add(timeParseButton,new GBC(3,3).setAnchor(GBC.WEST));
        add(lenientCheckbox,new GBC(0,4,2,1).setAnchor(GBC.WEST));

        add(dateText,new GBC(1,2,2,1).setFill(GBC.HORIZONTAL));
        add(timeText,new GBC(1,3,2,1).setFill(GBC.HORIZONTAL));

        locales = DateFormat.getAvailableLocales().clone();
        Arrays.sort(locales, Comparator.comparing(Locale::getDisplayName));

        for(Locale locale :locales){
            localeCombo.addItem(locale);
        }
        localeCombo.setSelectedItem(Locale.getDefault());

        currentDate = new Date();
        currentTime = new Date();
        updateDisplay();
        ActionListener listener = e -> {
            updateDisplay();
        };
        localeCombo.addActionListener(listener);
        dateStyleCombo.addActionListener(listener);
        timeStyleCombo.addActionListener(listener);

        dateParseButton.addActionListener(event->{
            String d = dateText.getText();
            try{
                currentDateFormat.setLenient(lenientCheckbox.isSelected());
                Date date = currentDateFormat.parse(d);
                currentDate = date;
                updateDisplay();
            }catch (ParseException | IllegalArgumentException e){
                dateText.setText("error -> " + d);
            }
        });
        timeParseButton.addActionListener(event->{
            String t = timeText.getText();
            try{
                currentTimeFormat.setLenient(lenientCheckbox.isSelected());
                Date time = currentTimeFormat.parse(t);
                currentTime = time;
                updateDisplay();
            }catch (ParseException | IllegalArgumentException e){
                dateText.setText("error -> " + t);
            }
        });
        pack();
    }

    public void updateDisplay(){
        Locale currentLocale = locales[localeCombo.getSelectedIndex()];
        int dateStyle = dateStyleCombo.getValue();
        currentDateFormat = DateFormat.getDateInstance(dateStyle,currentLocale);
        String d = currentDateFormat.format(currentDate);
        dateText.setText(d);

        int timeStyle = timeStyleCombo.getValue();
        currentTimeFormat = DateFormat.getTimeInstance(timeStyle,currentLocale);
        String t = currentTimeFormat.format(currentTime);
        timeText.setText(t);
    }

    /****
     * java.text.DateFormat
     * static Locale[] getAvailableLocales()
     * 返加可用的locale
     *
     * static DateFormat getDateInstance(int dateStyle)
     * static DateFormat getDateInstance(int dateStyle, Locale l)
     * static DateFormat getTimeInstance(int timeStyle)
     * static DateFormat getTimeInstance(int timeStyle, Locale l)
     * static DateFormat getDateTimeInstance(int dateStyle, int timeStyle)
     * static DateFormat getDateTimeInstance(int dateStyle, int timeStyle, Locale l)
     * 返回一个日期格式化器
     *
     * String format(Date d)
     * 对给定的日期/时间进行格式化
     *
     * Date parse(String s)
     * 解析给定字符串
     *
     * void setLenient(boolean b)
     * boolean getLenient()
     * 设置或获取是不是宽松模式
     *
     * void setCalendar(Calendar cal)
     * Calendar getCalendar()
     * 设置或获取日历对象
     *
     * void setTimeZone(TimeZone tz)
     * TimeZone getTimeZone()
     * 设置或获取时区
     *
     * void setNumberFormat(NumberFormat f)
     * NumberFormat getNumberFormat()
     * 设置或获取数据格式化器
     *
     * java.util.TimeZone
     * static String[] getAvailableIDs()
     * 获取所有支持的时区ID
     *
     * static TimeZone getDefault()
     * 获取默认的时区
     *
     * static TimeZone getTimeZone(String zimeZoneId)
     * 获取给定的ID时区
     *
     * String getID()
     * 获取时区ID
     *
     * String getDisplayName()
     * String getDisplayName(Locale locale)
     * String getDisplayName(boolean dayLight, int style)
     * String getDisplayName(boolean dayLight, int style, Locale locale)
     * 获取一个时区在默认或给定的locale中的显示名称，dayLight指定是否是夏令时
     *
     * boolean useDaylightTime()
     * 时区是否用夏令时
     *
     * boolean inDaylightTime(Date date)
     * 给定的时间是否是夏令时
     *
     */
}




