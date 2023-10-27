package packUnico;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class BusquedaLibros extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JRadioButton rdbtnLibro;
    private JRadioButton rdbtnAutor;
    private JRadioButton rdbtnISBN;

    public BusquedaLibros() {
        // Configuración de la ventana
        setForeground(new Color(128, 128, 192));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Maximizar la ventana en pantalla completa
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Creación del panel principal
        contentPane = new JPanel();
        contentPane.setBackground(new Color(51, 102, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Configuración de la barra de búsqueda
        textField = new JTextField();
        textField.setBounds(21, 55, 455, 30);
        contentPane.add(textField);
        textField.setColumns(10);

        // Configuración de la tabla y modelo de tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Libro");
        tableModel.addColumn("Autor");
        tableModel.addColumn("ISBN");

        table = new JTable(tableModel);
        table.setBounds(20, 40, 459, 494);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(31, 96, 1241, 877);
        contentPane.add(scrollPane);

        // Botón de búsqueda
        JButton btnNewButton_3 = new JButton("Buscar");
        btnNewButton_3.setFont(new Font("Old English Text MT", Font.PLAIN, 20));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Este método se activa cuando se presiona el botón "Buscar".
            }
        });
        btnNewButton_3.setBounds(1141, 55, 131, 30);
        contentPane.add(btnNewButton_3);

        // Línea divisoria
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 42, 1906, 2);
        contentPane.add(separator);

        // Etiqueta "Agregar Libro"
        JLabel lblNewLabel = new JLabel("Agregar Libro");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Old English Text MT", Font.BOLD, 40));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(1357, 96, 425, 71);
        contentPane.add(lblNewLabel);

        // Etiquetas y campos de entrada para título, autor e ISBN
        JLabel lblNewLabel_1 = new JLabel("Título");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Old English Text MT", Font.PLAIN, 18));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(1518, 245, 102, 46);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(1357, 302, 425, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Autor");
        lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1.setFont(new Font("Old English Text MT", Font.PLAIN, 18));
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setBounds(1527, 333, 84, 45);
        contentPane.add(lblNewLabel_1_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(1357, 389, 425, 20);
        contentPane.add(textField_2);

        JLabel lblNewLabel_1_2 = new JLabel("Isbn");
        lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_2.setFont(new Font("Old English Text MT", Font.PLAIN, 18));
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_2.setBounds(1527, 420, 84, 45);
        contentPane.add(lblNewLabel_1_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(1357, 476, 424, 20);
        contentPane.add(textField_3);

        // Botón "Agregar"
        JButton btnNewButton_1 = new JButton("Agregar");
        btnNewButton_1.setFont(new Font("Old English Text MT", Font.PLAIN, 44));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Este método se activa cuando se presiona el botón "Agregar".
                String titulo = textField_1.getText();
                String autor = textField_2.getText();
                String isbn = textField_3.getText();

                if (!titulo.isEmpty() && !autor.isEmpty() && !isbn.isEmpty()) {
                    Object[] row = { titulo, autor, isbn };
                    tableModel.addRow(row);

                    // Guardar el libro en el archivo
                    guardarLibroEnArchivo(titulo, autor, isbn);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
                }
            }
        });
        btnNewButton_1.setBounds(1357, 585, 425, 197);
        contentPane.add(btnNewButton_1);

        // Etiqueta "Búsqueda"
        JLabel lblNewLabel_2 = new JLabel("Búsqueda");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Old English Text MT", Font.BOLD, 29));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(823, -2, 261, 46);
        contentPane.add(lblNewLabel_2);

        // Botones de navegación
        JButton btnNewButton = new JButton("|>");
        btnNewButton.setFont(new Font("Old English Text MT", Font.BOLD, 16));
        btnNewButton.setBounds(1094, 10, 89, 23);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principal.cambiarAPrestamo();
            }
        });

        JButton btnNewButton_2 = new JButton("<|");
        btnNewButton_2.setFont(new Font("Old English Text MT", Font.BOLD, 16));
        btnNewButton_2.setBounds(724, 10, 89, 23);
        contentPane.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principal.cambiarAPrestamo();
            }
        });

        // Botones de radio para seleccionar criterio de búsqueda
        rdbtnAutor = new JRadioButton("Autor");
        rdbtnAutor.setForeground(new Color(255, 255, 255));
        rdbtnAutor.setBackground(new Color(51, 102, 204));
        rdbtnAutor.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnAutor.setFont(new Font("Old English Text MT", Font.PLAIN, 18));
        rdbtnAutor.setBounds(715, 59, 175, 23);
        contentPane.add(rdbtnAutor);

        rdbtnISBN = new JRadioButton("Isbn");
        rdbtnISBN.setForeground(new Color(255, 255, 255));
        rdbtnISBN.setBackground(new Color(51, 102, 204));
        rdbtnISBN.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnISBN.setFont(new Font("Old English Text MT", Font.PLAIN, 18));
        rdbtnISBN.setBounds(893, 59, 175, 23);
        contentPane.add(rdbtnISBN);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnAutor);
        buttonGroup.add(rdbtnISBN);

        rdbtnLibro = new JRadioButton("Libro");
        rdbtnLibro.setForeground(new Color(255, 255, 255));
        rdbtnLibro.setBackground(new Color(51, 102, 204));
        rdbtnLibro.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnLibro.setFont(new Font("Old English Text MT", Font.PLAIN, 18));
        rdbtnLibro.setBounds(536, 59, 175, 23);
        rdbtnLibro.setSelected(true);
        contentPane.add(rdbtnLibro);
        buttonGroup.add(rdbtnLibro);
        
        // Elemenos visuales
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBounds(1322, 42, 14, 767);
        contentPane.add(separator_1);
        
        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setOrientation(SwingConstants.VERTICAL);
        separator_1_1.setBounds(1816, 42, 14, 767);
        contentPane.add(separator_1_1);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(1322, 807, 494, 2);
        contentPane.add(separator_2);

        // Agregar un ActionListener para el botón de búsqueda
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Este método se activa cuando se presiona el botón "Buscar".
                // Obtiene la selección del JRadioButton
                String seleccion = obtenerSeleccionRadio();
                // Realiza la búsqueda y muestra los resultados en la JTable
                buscarYMostrarResultados(seleccion);
            }
        });

        // Cargar datos de libros desde el archivo al iniciar la aplicación
        cargarLibrosDesdeArchivo();
    }

    // Guardar libro en el archivo
    private void guardarLibroEnArchivo(String titulo, String autor, String isbn) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/packUnico/libros.txt", true))) {
            writer.write(titulo + "," + autor + "," + isbn);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Obtener selección de radio (Libro, Autor, ISBN o Todos)
    private String obtenerSeleccionRadio() {
        if (rdbtnLibro.isSelected()) {
            return "Libro";
        } else if (rdbtnAutor.isSelected()) {
            return "Autor";
        } else if (rdbtnISBN.isSelected()) {
            return "ISBN";
        }
        return "Todos"; 
    }

    // Realizar búsqueda y mostrar resultados en la tabla
    private void buscarYMostrarResultados(String seleccion) {
        tableModel.setRowCount(0); // Borra los datos existentes en la tabla

        try (BufferedReader reader = new BufferedReader(new FileReader("src/packUnico/libros.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    // Compara los detalles del libro con el criterio de búsqueda
                    String searchTerm = textField.getText().toLowerCase();
                    String partToCompare = parts[seleccion.equals("Libro") ? 0 : seleccion.equals("Autor") ? 1 : 2].toLowerCase();
                    
                    if (textField.getText().isEmpty() || partToCompare.contains(searchTerm)) {
                        // Agrega los detalles del libro a la tabla
                        Object[] row = { parts[0], parts[1], parts[2] };
                        tableModel.addRow(row);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cargar datos de libros desde el archivo al iniciar la aplicación
    private void cargarLibrosDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/packUnico/libros.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Object[] row = { parts[0], parts[1], parts[2] };
                    tableModel.addRow(row);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
