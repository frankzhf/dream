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

}
