COMPILE:   <h4> javac validate/*.java encoding/*.java conversion/*.java Main.java </h4>

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
>> 4B 68 6F 6F 72 20 7A 72 75 6F 67 (sur l exo tous les graphique ont le meme resultat: la conversion dans l image represent la conversion hexadecimale sans utilisation d'algo de chiffrement et pas avec )

$: java Main.java text "Khoor zruog" caesar -3
>> Q.: entrer la base d'encodage de votre chaine(ex hexadecimal, octal etc...):  *text*

>> Hello world

( ça ça ne marche pas )
$: java Main.java text "4B 68 6F 6F 72 20 7A 72 75 6F 67" caesar -3
>> Q.: entrer la base d'encodage de votre chaine(ex hexadecimal, octal etc...):  *hexadecimal*

>> ERROR: La chaine hexadecimale inseree n'est pas valide



**Titre : Global Converter - Un système complet de conversion de bases textuelles et numériques**

Le projet Global Converter est une application Java qui permet aux utilisateurs de convertir une chaîne de valeurs textuelles ou numériques d'une base à une autre. Les bases prises en charge comprennent le binaire, le décimal, l'octal, l'hexadécimal et même le texte brut. En outre, l'application prend également en charge l'utilisation d'algorithmes de chiffrement, tels que le chiffrement de César, pour crypter le texte d'entrée avant la conversion.

**Composants clés:**

*1. Validation de l'entrée utilisateur:*
L'application requiert au moins deux arguments de la part de l'utilisateur : la base à partir de laquelle la conversion doit être effectuée et le texte ou les valeurs numériques à convertir. Un algorithme et une clé de cryptage facultatifs peuvent également être fournis. La classe "Validate" est utilisée pour garantir la validité de ces entrées. Si une entrée est invalide ou insuffisante, un message d'erreur s'affiche et le programme se termine.

*2. Cryptage:*
L'application prend en charge l'utilisation d'algorithmes de cryptage sur l'entrée avant la conversion. La classe 'EncodingStrategyFactory' est utilisée pour sélectionner la bonne stratégie d'encodage en fonction des données de l'utilisateur. Actuellement, le chiffrement Caesar est implémenté, mais d'autres chiffrages peuvent être facilement ajoutés grâce à la conception modulaire du système. Si aucun algorithme de cryptage n'est fourni, le système utilise par défaut un "defaultEncoding", qui laisse l'entrée inchangée.

*3. Conversion:*
La fonctionnalité principale de l'application réside dans ses stratégies de conversion. En fonction de la base fournie par l'utilisateur, une stratégie de conversion appropriée est choisie. La classe 'Ascii' est utilisée pour convertir le texte d'entrée en ASCII, qui sert ensuite d'entrée à ces stratégies. Chaque base (binaire, décimale, octale, hexadécimale et texte) possède sa propre stratégie de conversion, mise en œuvre à l'aide de l'interface "ConversionStrategy".

*4. Sortie:*
La chaîne convertie est ensuite imprimée sur la console. Si l'entrée était cryptée, la sortie sera la forme cryptée de l'entrée originale, convertie dans la base spécifiée.