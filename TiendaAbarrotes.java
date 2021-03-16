package crud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TiendaAbarrotes extends JFrame implements ActionListener
{

   JTextField txtcve_art, txtnom_art, txtcat_art, txtprov_art, txtpre_art, txtinv_art;
   JButton firstBtn, lastBtn, nextBtn, previousBtn, addBtn, updateBtn, deleteBtn, saveBtn, exitBtn;
   ArrayList<Articulo> articleList = new ArrayList<>();
   private int recordCursor, position, i;
   private boolean AU = true;

    public static void main(String[] args)
    {
        TiendaAbarrotes ta = new TiendaAbarrotes();
        EventQueue.invokeLater(() -> {
            try
            {
                ta.setVisible(true);
                ta.setBounds(100,100,580,340);
                ta.initialize();
                ta.setResizable(false);
                ta.setLocationRelativeTo(null);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });
    }

    private void initialize()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tienda de Abarrotes");
        Container frame =  this.getContentPane();
        frame.setLayout(null);

        //Instanciar objetos
        JLabel lbcve_art = new JLabel("Clave: ");
        lbcve_art.setBounds(38, 10, 76, 16);
        JLabel lbnom_art = new JLabel("Nombre: ");
        lbnom_art.setBounds(38, 39, 96, 16);
        JLabel lbcat_art = new JLabel("Categoria: ");
        lbcat_art.setBounds(38,68,96,16);
        JLabel lbprov_art = new JLabel("Proveedor: ");
        lbprov_art.setBounds(38,97,96,16);
        JLabel lbpre_art = new JLabel("Precio: ");
        lbpre_art.setBounds(38, 126,96,16);
        JLabel lbinv_art = new JLabel("Inventario: ");
        lbinv_art.setBounds(38, 155, 96,16);

        txtcve_art = new JTextField(10);
        txtcve_art.setBounds(141,7,376,22);
        txtnom_art = new JTextField(10);
        txtnom_art.setBounds(141, 36, 376, 22);
        txtcat_art = new JTextField(10);
        txtcat_art.setBounds(141, 65, 376,22);
        txtprov_art = new JTextField(10);
        txtprov_art.setBounds(141,94,376,22);
        txtpre_art = new JTextField(10);
        txtpre_art.setBounds(141, 123, 376,22);
        txtinv_art = new JTextField();
        txtinv_art.setBounds(141, 152, 376, 22);

        firstBtn = new JButton("Primero");
        firstBtn.setForeground(Color.BLUE);
        firstBtn.setBounds(15, 191, 125, 25);
        previousBtn = new JButton("Anterior");
        previousBtn.setForeground(Color.BLUE);
        previousBtn.setBounds(152, 191, 125,25);
        nextBtn = new JButton("Siguiente");
        nextBtn.setForeground(Color.BLUE);
        nextBtn.setBounds(289, 191,125,25);
        lastBtn = new JButton("Ultimo");
        lastBtn.setForeground(Color.BLUE);
        lastBtn.setBounds(426,191,125,25);

        addBtn = new JButton("Nuevo/Agregar");
        addBtn.setForeground(Color.BLUE);
        addBtn.setBounds(15, 228, 125, 25);
        updateBtn = new JButton("Editar");
        updateBtn.setForeground(Color.BLUE);
        updateBtn.setBounds(152, 228, 125, 25);
        deleteBtn = new JButton("Eliminar");
        deleteBtn.setForeground(Color.BLUE);
        deleteBtn.setBounds(289, 228, 125, 25);
        saveBtn = new JButton("Guardar");
        saveBtn.setForeground(Color.BLUE);
        saveBtn.setBounds(426, 228, 125, 25);
        exitBtn = new JButton("Salir");
        exitBtn.setForeground(Color.BLUE);
        exitBtn.setBounds(213, 265, 125, 25);

        //Agregar objetos
        frame.add(lbcve_art);
        frame.add(txtcve_art);
        frame.add(lbnom_art);
        frame.add(txtnom_art);
        frame.add(lbcat_art);
        frame.add(txtcat_art);
        frame.add(lbprov_art);
        frame.add(txtprov_art);
        frame.add(lbpre_art);
        frame.add(txtpre_art);
        frame.add(lbinv_art);
        frame.add(txtinv_art);

        frame.add(firstBtn);
        frame.add(previousBtn);
        frame.add(nextBtn);
        frame.add(lastBtn);
        frame.add(addBtn);
        frame.add(updateBtn);
        frame.add(deleteBtn);
        frame.add(saveBtn);
        frame.add(exitBtn);

        firstBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        previousBtn.addActionListener(this);
        lastBtn.addActionListener(this);
        addBtn.addActionListener(this);
        saveBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        //Bloquar botones al iniciar el programa
        if(articleList.size() == 0)
        {
            addBtn.setEnabled(true);
            updateBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
            firstBtn.setEnabled(false);
            lastBtn.setEnabled(false);
            saveBtn.setEnabled(true);
            nextBtn.setEnabled(false);
            previousBtn.setEnabled(false);
            areTextFieldsEditable(false);
        }
    }

    //Actualizar los espacios del articulo actual
    private void updateArticleForm(Articulo articulo)
    {
        txtcve_art.setText(Integer.toString(articulo.cve_art));
        txtnom_art.setText(articulo.nom_art);
        txtcat_art.setText(Integer.toString(articulo.cat_art));
        txtprov_art.setText(Integer.toString(articulo.prov_art));
        txtpre_art.setText(Float.toString(articulo.pre_art));
        txtinv_art.setText(Integer.toString(articulo.inv_art));
    }

    //Definir los espacios en modo lectura o escritura
    private void areTextFieldsEditable(boolean flag)
    {
        txtcve_art.setEditable(flag);
        txtnom_art.setEditable(flag);
        txtcat_art.setEditable(flag);
        txtprov_art.setEditable(flag);
        txtpre_art.setEditable(flag);
        txtinv_art.setEditable(flag);
    }

    private void areMoveButtonsEnabled(boolean flag)
    {
        firstBtn.setEnabled(flag);
        previousBtn.setEnabled(flag);
        nextBtn.setEnabled(flag);
        lastBtn.setEnabled(flag);
    }

    private void conditionForButtons()
    {
        if(articleList.size() == 0)
        {
            addBtn.setEnabled(true);
            updateBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
            firstBtn.setEnabled(false);
            lastBtn.setEnabled(false);
            saveBtn.setEnabled(true);
            nextBtn.setEnabled(false);
            previousBtn.setEnabled(false);
        }
        else if(articleList.size() == 1)
        {
            for(JButton jButton : Arrays.asList(updateBtn, deleteBtn, addBtn, exitBtn, saveBtn))
            {
                jButton.setEnabled(true);
            }
        }
        else if(articleList.size() > 1)
        {
            for(JButton jButton : Arrays.asList(firstBtn, lastBtn, updateBtn, deleteBtn, nextBtn, previousBtn, addBtn))
            {
                jButton.setEnabled(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)//ESCUCHADOR
    {
        areTextFieldsEditable(false);
        if(e.getSource() == firstBtn)//Boton primer elemento
        {
            recordCursor = 0;
            Articulo articulo = articleList.get(recordCursor);
            updateArticleForm(articulo);
            areTextFieldsEditable(false);
            conditionForButtons();
            firstBtn.setEnabled(false);
            previousBtn.setEnabled(false);
            if(articleList.size() == 1)
            {
                nextBtn.setEnabled(false);
                lastBtn.setEnabled(false);
            }
        }
        else if(e.getSource() == previousBtn)//Boton anterior
        {
            recordCursor--;
            Articulo articulo = articleList.get(recordCursor);
            updateArticleForm(articulo);
            areTextFieldsEditable(false);
            conditionForButtons();
            if(recordCursor == 0)
            {
                articleList.get(recordCursor);
                previousBtn.setEnabled(false);
                firstBtn.setEnabled(false);
                nextBtn.setEnabled(true);
                lastBtn.setEnabled(true);
            }
            else if(articleList.size() >= 2)
            {
                areMoveButtonsEnabled(true);
            }
        }
        else if(e.getSource() == nextBtn)//Boton siguiente
        {
            recordCursor++;
            Articulo articulo = articleList.get(recordCursor);
            updateArticleForm(articulo);
            areTextFieldsEditable(false);
            if(recordCursor == (articleList.size()-1))
            {
                nextBtn.setEnabled(false);
                lastBtn.setEnabled(false);
                firstBtn.setEnabled(true);
                previousBtn.setEnabled(true);
            }
            else if(articleList.size() >= 2)
            {
                areMoveButtonsEnabled(true);
            }
        }
        else if(e.getSource() == lastBtn)//Boton ultimo elemento
        {
            Articulo articulo = articleList.get(articleList.size()-1);
            updateArticleForm(articulo);
            areTextFieldsEditable(false);
            conditionForButtons();
            nextBtn.setEnabled(false);
            lastBtn.setEnabled(false);
            firstBtn.setEnabled(true);
            previousBtn.setEnabled(true);
        }
        else if(e.getSource() == addBtn) //Boton agregar
        {
            updateBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
            areMoveButtonsEnabled(false);
            cleanForm();
            areTextFieldsEditable(true);
        }
        else if(e.getSource() == saveBtn)//Boton guardar
        {
            saveArticle();
            areTextFieldsEditable(false);
            Articulo articulo = articleList.get(recordCursor);
            updateArticleForm(articulo);
            conditionForButtons();
            if(articleList.size() >= 2)
            {
                previousBtn.setEnabled(false);
                firstBtn.setEnabled(false);
            }
        }
        else if(e.getSource() == updateBtn)//Boton editar
        {
            areMoveButtonsEnabled(false);
            updateArticle();
        }
        else if(e.getSource() == deleteBtn)//Boton eliminar
        {
            areMoveButtonsEnabled(false);
            deleteArticle();
            cleanForm();
            areTextFieldsEditable(false);
            recordCursor = 0;
            Articulo articulo = articleList.get(recordCursor);
            updateArticleForm(articulo);
            conditionForButtons();
            if(articleList.size() >= 2)
            {
                previousBtn.setEnabled(false);
                firstBtn.setEnabled(false);
            }
        }
        else if(e.getSource() == exitBtn)//Boton salir
        {
            System.exit(0);
        }
    }

    private void cleanForm()
    {
        txtcve_art.setText("");
        txtnom_art.setText("");
        txtcat_art.setText("");
        txtprov_art.setText("");
        txtpre_art.setText("");
        txtinv_art.setText("");
    }

    private void deleteArticle()
    {
        int cve = Integer.parseInt(txtcve_art.getText());
        i = 0;
        for(Articulo articulo : articleList)
        {
            if(articulo.cve_art == cve)
            {
                position = i;
            }
            i += 1;
        }
        int ans = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este articulo?","" ,JOptionPane.YES_NO_OPTION);
        if(ans == JOptionPane.YES_OPTION)
        {
            boolean secure = true;
            cve = Integer.parseInt(txtcve_art.getText());
            for(Articulo articulo : articleList)
            {
                if (articulo.cve_art == cve && articulo != articleList.get(position)) {
                    secure = false;
                    break;
                }
            }
            if(secure)
            {
                try
                {
                    articleList.removeIf(articulo -> articulo.cve_art == Integer.parseInt(txtcve_art.getText()));
                    JOptionPane.showMessageDialog(null, "Articulo eliminado exitosamente");
                    conditionForButtons();
                    areTextFieldsEditable(false);
                } catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el articulo deseado");
                    areTextFieldsEditable(false);
                    cleanForm();
                    conditionForButtons();
                }
            }
        }
    }

    private void updateArticle()
    {
        AU = false;
        int cve = Integer.parseInt(txtcve_art.getText());
        i = 0;
        for(Articulo articulo : articleList)
        {
            if(articulo.cve_art == cve)
            {
              position = i;
            }
            i += 1;
        }
        for(JButton jButton : Arrays.asList(firstBtn, lastBtn, updateBtn, deleteBtn, nextBtn, previousBtn, addBtn))
        {
            jButton.setEnabled(false);
        }
        areTextFieldsEditable(true);
    }

    private void addArticle()//Metodo añadir
    {
        AU = true;
        if(!(txtcve_art.getText().equals("") || txtnom_art.getText().equals("") || txtcat_art.getText().equals("") || txtprov_art.getText().equals("") || txtpre_art.getText().equals("") || txtinv_art.getText().equals("")))
        {
            boolean secure = true;
            int cve = Integer.parseInt(txtcve_art.getText());
            for(Articulo articulo : articleList)
            {
                if (articulo.cve_art == cve) {
                    secure = false;
                    JOptionPane.showMessageDialog(null, "Clave existente");
                    recordCursor = 0;
                    updateArticleForm(articulo);
                    areTextFieldsEditable(false);
                    conditionForButtons();
                    break;
                }
            }
            if(secure)
            {
                String nom = txtnom_art.getText();
                int cat = Integer.parseInt(txtcat_art.getText());
                int prov = Integer.parseInt(txtprov_art.getText());
                float pre = Float.parseFloat(txtpre_art.getText());
                int inv = Integer.parseInt(txtinv_art.getText());
                articleList.add(new Articulo(cve, nom, cat, prov, pre, inv));
                cleanForm();
                conditionForButtons();
                JOptionPane.showMessageDialog(null, "Articulo guardado exitosamente");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Campos restantes por llenar");
            cleanForm();
        }

    }

    private void saveArticle()
    {
        if(AU)
        {
            addArticle();
            recordCursor = 0;
            Articulo articulo = articleList.get(recordCursor);
            updateArticleForm(articulo);
        }
        else
        {
            int ans = JOptionPane.showConfirmDialog(null, "¿Esta seguro de realizar los cambios?","" ,JOptionPane.YES_NO_OPTION);
            if(ans == JOptionPane.YES_OPTION)
            {
                boolean secure = true;
                int cve = Integer.parseInt(txtcve_art.getText());
                for(Articulo article : articleList)
                {
                    if (article.cve_art == cve && article != articleList.get(position))
                    {
                        secure = false;
                        JOptionPane.showMessageDialog(null, "Clave existente");
                        recordCursor = 0;
                        areTextFieldsEditable(false);
                        conditionForButtons();
                        break;
                    }
                }
                if(secure)
                {
                    String nom = txtnom_art.getText();
                    int cat = Integer.parseInt(txtcat_art.getText());
                    int prov = Integer.parseInt(txtprov_art.getText());
                    float pre = Float.parseFloat(txtpre_art.getText());
                    int inv = Integer.parseInt(txtinv_art.getText());

                    Articulo articulo = articleList.get(position);
                    articulo.cve_art = cve;
                    articulo.nom_art = nom;
                    articulo.cat_art = cat;
                    articulo.prov_art = prov;
                    articulo.pre_art = pre;
                    articulo.inv_art = inv;

                    areTextFieldsEditable(false);
                    conditionForButtons();
                }
                Collections.sort(articleList);
                recordCursor = 0;
                Articulo articulo = articleList.get(recordCursor);
                updateArticleForm(articulo);
            }
            else
            {
                areTextFieldsEditable(false);
                cleanForm();
                conditionForButtons();
            }
        }
    }


}
