package packUnico;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestamos extends JFrame {

    // Declaración de componentes de la interfaz de usuario
    private JPanel contentPane;
    private JTextField textField;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JRadioButton rdbtnLibro;
    private JRadioButton rdbtnUsuario;

    public Prestamos() {
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
        tableModel = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        tableModel.addColumn("Usuario");
        tableModel.addColumn("Libro");
        tableModel.addColumn("Fecha Préstamo");
        tableModel.addColumn("Fecha Entrega");
        tableModel.addColumn("Devolución");

        table = new JTable(tableModel);
        table.setBounds(20, 40, 459, 494);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(31, 96, 1241, 876);
        contentPane.add(scrollPane);

        // Botón de búsqueda
        JButton btnNewButton_3 = new JButton("Buscar");
        btnNewButton_3.setBackground(UIManager.getColor("Label.disabledForeground"));
        btnNewButton_3.setForeground(Color.BLACK);
        btnNewButton_3.setFont(new Font("Old English Text MT", Font.PLAIN, 20));
        btnNewButton_3.setBounds(1141, 55, 131, 30);
        contentPane.add(btnNewButton_3);

        // Línea divisoria
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 42, 1921, 2);
        contentPane.add(separator);

        // Etiqueta "Agregar Préstamo"
        JLabel lblNewLabel = new JLabel("Agregar Préstamo");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Old English Text MT", Font.BOLD, 40));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(1357, 96, 425, 71);
        contentPane.add(lblNewLabel);

        // Etiquetas y campos de entrada para usuario, libro y fecha
        JLabel lblNewLabel_1 = new JLabel("Usuario");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Old English Text MT", Font.PLAIN, 18));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(1518, 245, 102, 46);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(1357, 302, 425, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Libro");
        lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1.setFont(new Font("Old English Text MT", Font.PLAIN, 18));
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setBounds(1518, 333, 102, 46);
        contentPane.add(lblNewLabel_1_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(1357, 389, 425, 20);
        contentPane.add(textField_2);

        JLabel lblNewLabel_1_2 = new JLabel("Fecha Límite");
        lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_2.setFont(new Font("Old English Text MT", Font.PLAIN, 18));
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_2.setBounds(1518, 420, 102, 46);
        contentPane.add(lblNewLabel_1_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(1357, 476, 425, 20);
        contentPane.add(textField_3);

        // Botón "Agregar"
        JButton btnNewButton_1 = new JButton("Agregar");
        btnNewButton_1.setForeground(new Color(0, 0, 0));
        btnNewButton_1.setFont(new Font("Old English Text MT", Font.PLAIN, 24));
        btnNewButton_1.setBounds(1467, 544, 204, 76);
        contentPane.add(btnNewButton_1);

        // Etiqueta "Préstamos"
        JLabel lblNewLabel_2 = new JLabel("Préstamos");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Old English Text MT", Font.BOLD, 29));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(830, -2, 261, 46);
        contentPane.add(lblNewLabel_2);

        // Botones de navegación
        JButton btnNewButton = new JButton("|>");
        btnNewButton.setBackground(UIManager.getColor("Label.disabledForeground"));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setFont(new Font("Old English Text MT", Font.BOLD, 16));
        btnNewButton.setBounds(1101, 10, 89, 23);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principal.cambiarABusqueda();
            }
        });

        JButton btnNewButton_2 = new JButton("<|");
        btnNewButton_2.setBackground(UIManager.getColor("Label.disabledForeground"));
        btnNewButton_2.setForeground(new Color(0, 0, 0));
        btnNewButton_2.setFont(new Font("Old English Text MT", Font.BOLD, 16));
        btnNewButton_2.setBounds(731, 10, 89, 23);
        contentPane.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Principal.cambiarABusqueda();
            }
        });

        // Botones de radio para seleccionar criterio de búsqueda
        rdbtnUsuario = new JRadioButton("Usuario");
        rdbtnUsuario.setBackground(new Color(51, 102, 204));
        rdbtnUsuario.setForeground(new Color(255, 255, 255));
        rdbtnUsuario.setFont(new Font("Old English Text MT", Font.PLAIN, 18));
        rdbtnUsuario.setBounds(645, 56, 175, 23);
        rdbtnUsuario.setSelected(true);
        contentPane.add(rdbtnUsuario);

        rdbtnLibro = new JRadioButton("Libro");
        rdbtnLibro.setBackground(new Color(51, 102, 204));
        rdbtnLibro.setForeground(new Color(255, 255, 255));
        rdbtnLibro.setFont(new Font("Old English Text MT", Font.PLAIN, 18));
        rdbtnLibro.setBounds(840, 56, 175, 23);
        contentPane.add(rdbtnLibro);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnUsuario);
        buttonGroup.add(rdbtnLibro);

        // Botón "Devolver"
        JButton btnDevolver = new JButton("Devolver");
        btnDevolver.setForeground(new Color(0, 0, 0));
        btnDevolver.setFont(new Font("Old English Text MT", Font.PLAIN, 44));
        btnDevolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                devolverPrestamos(); // Llama al método para eliminar entradas en el archivo
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    Boolean devolucion = (Boolean) tableModel.getValueAt(i, 4);
                    if (devolucion) {
                        tableModel.removeRow(i);
                        i--; // Ajustar el índice después de eliminar una fila
                    }
                }
            }
        });
        btnDevolver.setBounds(1357, 775, 425, 197);
        contentPane.add(btnDevolver);

        // Línea divisoria vertical
        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBounds(1320, 43, 14, 651);
        contentPane.add(separator_1);

        // Línea divisoria horizontal
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(1320, 692, 498, 14);
        contentPane.add(separator_2);

        // Línea divisoria vertical
        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setOrientation(SwingConstants.VERTICAL);
        separator_1_1.setBounds(1817, 43, 14, 651);
        contentPane.add(separator_1_1);

        // Agregar ActionListener para el botón "Agregar"
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarPrestamo();
            }
        });

        // Agregar ActionListener para el botón de búsqueda
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarPrestamos();
            }
        });

        // Cargar datos de préstamos desde el archivo al iniciar la aplicación
        cargarPrestamosDesdeArchivo();
    }


    private void agregarPrestamo() {
        String usuario = textField_1.getText();
        String libro = textField_2.getText();
        String fechaEntrega = textField_3.getText();
        String fechaActual = obtenerFechaActual();

        // Expresión regular para verificar el formato de la fecha (XX/XX/XXXX)
        String formatoFecha = "\\d{2}/\\d{2}/\\d{4}";

        // Verificar el formato de la fecha
        if (!fechaEntrega.matches(formatoFecha)) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha válida en el formato XX/XX/XXXX.");
            return;
        }

        // Parsear la fecha
        String[] fechaPartes = fechaEntrega.split("/");
        int dia = Integer.parseInt(fechaPartes[0]);
        int mes = Integer.parseInt(fechaPartes[1]);
        int año = Integer.parseInt(fechaPartes[2]);

        // Verificar que la fecha sea válida y no anterior a la fecha actual
        if (!fechaEsValida(dia, mes, año) || fechaEsAnterior(dia, mes, año)) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha válida y no anterior a la fecha actual.");
            return;
        }

        // Si todo está correcto, agregar el préstamo
        Boolean devolucion = false;
        Object[] row = {usuario, libro, fechaActual, fechaEntrega, devolucion};
        tableModel.addRow(row);

        // Guardar el préstamo en el archivo
        guardarPrestamoEnArchivo(usuario, libro, fechaActual, fechaEntrega, devolucion);
    }

    private boolean fechaEsValida(int dia, int mes, int año) {
        // Verificar si el día y el mes son válidos
        if (mes < 1 || mes > 12 || dia < 1 || dia > diasEnMes(mes, año)) {
            return false;
        }
        return true;
    }

    private boolean fechaEsAnterior(int dia, int mes, int año) {
        // Obtener la fecha actual
        String fechaActual = obtenerFechaActual();
        String[] fechaActualPartes = fechaActual.split("/");
        int añoActual = Integer.parseInt(fechaActualPartes[2]);
        int mesActual = Integer.parseInt(fechaActualPartes[1]);
        int diaActual = Integer.parseInt(fechaActualPartes[0]);

        // Verificar si la fecha ingresada es anterior a la fecha actual
        if (año < añoActual || (año == añoActual && (mes < mesActual || (mes == mesActual && dia < diaActual)))) {
            return true;
        }
        return false;
    }

    private int diasEnMes(int mes, int año) {
        int[] diasEnMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (mes == 2 && esBisiesto(año)) {
            return 29; // Febrero en año bisiesto
        }
        return diasEnMes[mes];
    }

    private boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }


    private void buscarPrestamos() {
        // Borra los datos existentes en la tabla
        tableModel.setRowCount(0);

        try (BufferedReader reader = new BufferedReader(new FileReader("src/packUnico/prestamos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String searchText = textField.getText().toLowerCase();
                    String usuario = parts[0].toLowerCase();
                    String libro = parts[1].toLowerCase();
                    boolean usuarioMatches = searchText.isEmpty() || usuario.contains(searchText);
                    boolean libroMatches = searchText.isEmpty() || libro.contains(searchText);

                    if (usuarioMatches || libroMatches) {
                        Boolean devolucion = Boolean.parseBoolean(parts[4]);
                        Object[] row = {parts[0], parts[1], parts[2], parts[3], devolucion};
                        tableModel.addRow(row);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


 // Este método se encarga de eliminar los préstamos marcados como devueltos y actualizar el archivo de préstamos.
    private void devolverPrestamos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/packUnico/prestamos.txt", false))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                // Obtener información del préstamo desde la tabla.
                String usuario = (String) tableModel.getValueAt(i, 0);
                String libro = (String) tableModel.getValueAt(i, 1);
                String fechaPrestamo = (String) tableModel.getValueAt(i, 2);
                String fechaEntrega = (String) tableModel.getValueAt(i, 3);
                Boolean devolucion = (Boolean) tableModel.getValueAt(i, 4);

                // Verificar si el préstamo no ha sido marcado como devuelto.
                if (!devolucion) {
                    // Escribir el préstamo en el archivo de préstamos.
                    writer.write(usuario + "," + libro + "," + fechaPrestamo + "," + fechaEntrega + "," + devolucion);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Este método se utiliza para agregar un nuevo préstamo al archivo de préstamos.
    private void guardarPrestamoEnArchivo(String usuario, String libro, String fechaPrestamo, String fechaEntrega, Boolean devolucion) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/packUnico/prestamos.txt", true))) {
            // Escribir los detalles del nuevo préstamo en el archivo.
            writer.write(usuario + "," + libro + "," + fechaPrestamo + "," + fechaEntrega + "," + devolucion);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Este método se encarga de cargar los préstamos desde el archivo al iniciar la aplicación.
    private void cargarPrestamosDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/packUnico/prestamos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    // Parsear la información del préstamo desde el archivo.
                    Boolean devolucion = Boolean.parseBoolean(parts[4]);
                    Object[] row = {parts[0], parts[1], parts[2], parts[3], devolucion};

                    // Agregar el préstamo a la tabla de préstamos en la aplicación.
                    tableModel.addRow(row);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Este método obtiene la fecha actual en el formato "dd/MM/yyyy".
    private String obtenerFechaActual() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}