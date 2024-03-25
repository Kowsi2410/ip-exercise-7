import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Sample list of books
    private ArrayList<Book> books = new ArrayList<>();

    public BookServlet() {
        // Adding sample books
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("Pride and Prejudice", "Jane Austen"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the sort parameter from the request
        String sortBy = request.getParameter("sort");
        
        // Sort the books based on the selected option
        if ("author".equals(sortBy)) {
            Collections.sort(books, Comparator.comparing(Book::getAuthor));
        } else {
            // Default to sorting by title
            Collections.sort(books, Comparator.comparing(Book::getTitle));
        }
        
        // Set the books list as an attribute in the request
        request.setAttribute("books", books);
        
        // Forward the request to the JSP page
        request.getRequestDispatcher("books.jsp").forward(request, response);
    }
}
