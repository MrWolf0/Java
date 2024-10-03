# PDF Table Generation with Apache PDFBox

This project demonstrates how to generate a simple table in a PDF file using **Apache PDFBox**.

## Project Structure
- **Main.java**: The main class that initializes the helper class.
- **Helper.java**: Contains logic for generating a PDF file with a table. The table has rows and columns with specified widths and heights.

## Features
- Creates a PDF file.
- Draws a table with a configurable number of rows and columns.
- Uses Apache PDFBox for PDF manipulation.

## Installation

1. **Clone the repository** (if using Git):
   ```bash
   git clone https://github.com/your-username/your-repository.git
## Add the PDFBox dependency to your pom.xml (for Maven):

```xml
<dependency>
  <groupId>org.apache.pdfbox</groupId>
  <artifactId>pdfbox</artifactId>
  <version>2.0.27</version>
</dependency>

```

## Usage

```xml
Run the project:
Execute Main.java, which calls Helper.java to generate a PDF file.
Generated PDF:
The PDF file will be saved at E:/App/subscriber_bill.pdf by default.
The file contains a table with a defined number of rows and columns.
```


## Authors

- [@Nasser Eldin](https://www.github.com/MrWolf0)


## License

[MIT](https://choosealicense.com/licenses/mit/)

