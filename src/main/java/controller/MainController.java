package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Library;
import model.Book;

public class MainController {

    @FXML private TextField isbnField;
    @FXML private TextField tituloField;
    @FXML private TextField autorField;

    @FXML private TableView<Book> tablaLibros;
    @FXML private TableColumn<Book, String> colIsbn;
    @FXML private TableColumn<Book, String> colTitulo;
    @FXML private TableColumn<Book, String> colAutor;

    private Library biblioteca = new Library();
    private ObservableList<Book> listaLibros = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        // Conectar columnas
        colIsbn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getIsbn()));
        colTitulo.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTitle()));
        colAutor.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getAuthor()));

        tablaLibros.setItems(listaLibros);

        // Selección de tabla → llenar campos
        tablaLibros.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, libro) -> {
            if (libro != null) {
                isbnField.setText(libro.getIsbn());
                tituloField.setText(libro.getTitle());
                autorField.setText(libro.getAuthor());
            }
        });
    }

    // CREATE
    @FXML
    public void agregarLibro() {
        String isbn = isbnField.getText();

        if (isbn.isEmpty()) {
            mostrar("ISBN requerido");
            return;
        }

        Book libro = new Book(isbn, tituloField.getText(), autorField.getText());

        if (biblioteca.insertBook(libro)) {
            listaLibros.add(libro);
            mostrar("Libro agregado");
            limpiar();
        } else {
            mostrar("ISBN duplicado");
        }
    }

    // UPDATE
    @FXML
    public void editarLibro() {
        boolean actualizado = biblioteca.updateBook(
                isbnField.getText(),
                tituloField.getText(),
                autorField.getText()
        );

        if (actualizado) {
            refrescarTabla();
            mostrar("Libro actualizado");
        } else {
            mostrar("No existe el libro");
        }
    }

    // DELETE
    @FXML
    public void eliminarLibro() {
        String isbn = isbnField.getText();

        if (biblioteca.deleteBook(isbn)) {
            listaLibros.removeIf(l -> l.getIsbn().equals(isbn));
            mostrar("Libro eliminado");
            limpiar();
        } else {
            mostrar("No existe");
        }
    }

    private void refrescarTabla() {
        listaLibros.setAll(biblioteca.getBook());
    }

    private void limpiar() {
        isbnField.clear();
        tituloField.clear();
        autorField.clear();
    }

    private void mostrar(String msg) {
        System.out.println(msg);
    }
}