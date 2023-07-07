**Current Conversions**

hexadecimal -h
decimal -d
octal -o
binary -b
text -t

**Current Algos**

Caesar = "caesar"      utilisation: $: java Main.java text "Hello world" caesar 3

**Usage Exemples**

$: java Main.java binary "Hello world"  
>> 1001000 1100101 1101100 1101100 1101111 100000 1110111 1101111 1110010 1101100 1100100    

$: java Main.java hexadecimal "Hello world"
>> 48 65 6C 6C 6F 20 77 6F 72 6C 64

$: java Main.java text "48 65 6C 6C 6F 20 77 6F 72 6C 64"
>> Q.: entrer la base d'encodage de votre chaine(ex hexadecimal, octal etc...):  *hexadecimal*
>> Hello world

$: java Main.java text "Hello world" caesar 3
>> Khoor zruog

$: java Main.java hexadecimal "Hello world" caesar 3
>> 4B 68 6F 6F 72 20 7A 72 75 6F 67 (sur l exo il y a un graphique, page 6: la conversion dans l image represent la conversion hexadecimale sans utilisation d'algo de chiffrement et pas avec )

$: java Main.java text "Khoor zruog" caesar -3
>> Q.: entrer la base d'encodage de votre chaine(ex hexadecimal, octal etc...):  *text*
>> Hello world

( ça ça ne marche pas )
$: java Main.java text "4B 68 6F 6F 72 20 7A 72 75 6F 67" caesar -3
>> Q.: entrer la base d'encodage de votre chaine(ex hexadecimal, octal etc...):  *hexadecimal*
>> ERROR: La chaine hexadecimale inseree n'est pas valide





**Title: Global Converter - A Comprehensive Text and Numerical Base Conversion System**

The Global Converter project is a Java-based application that allows users to convert a string of text or numerical values from one base to another. The supported bases include binary, decimal, octal, hexadecimal, and even plain text. Furthermore, the application also supports the use of cipher algorithms, such as the Caesar cipher, to encrypt the input text before conversion.

**Key Components:**

*1. User Input Validation:*
The application requires at least two arguments from the user; the base to convert from, and the text or numerical values to convert. An optional encryption algorithm and key may also be provided. The 'Validate' class is used to ensure the validity of these inputs. If any input is invalid or insufficient, an error message is displayed and the program exits.

*2. Encryption:*
The application supports the use of encryption algorithms on the input before conversion. The 'EncodingStrategyFactory' class is used to select the right encoding strategy based on user input. Currently, the Caesar cipher is implemented, but other ciphers could easily be added due to the system's modular design. If no encryption algorithm is provided, the system defaults to a 'defaultEncoding', which leaves the input unchanged.

*3. Conversion:*
The core functionality of the application lies in its conversion strategies. Depending on the base provided by the user, an appropriate conversion strategy is chosen. The 'Ascii' class is used to convert input text to ASCII, which then serves as the input for these strategies. Each base (binary, decimal, octal, hexadecimal, and text) has its own conversion strategy, implemented using a 'ConversionStrategy' interface.

*4. Output:*
The converted string is then printed to the console. If the input was encrypted, the output will be the encrypted form of the original input, converted to the specified base.

The project demonstrates strong use of object-oriented principles, including encapsulation, polymorphism, and inheritance, and employs the Strategy design pattern to allow for easy addition of new conversion or encoding strategies. It also handles user input and potential errors robustly, making for a versatile and user-friendly application.

With further development, this project could be expanded to support more bases for conversion, additional encryption algorithms, or even a GUI to improve user experience.