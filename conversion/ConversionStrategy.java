package conversion;


/* 
 Strategy Design pattern

 we define a algos fam through an interface. the client will have only one method 
 and all the definition of the conversion will be hidden.
 The encapsulation of the algos in this pattern make them intercheangeable without the 
 need to explicitly call them
 
*/
public interface ConversionStrategy {

    String convert(String ascii);
}

