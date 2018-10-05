package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {
    
	String sudokuCorrecto = "978236451"
						  + "143785629"
						  + "256419837"
						  + "815624793"
						  + "437951286"
						  + "629873514"
						  + "564192378"
						  + "381567942"
						  + "792348165";
	
	String sudokuInvalidChar = "978236451"
						     + "143785629"
						     + "256419837"
						     + "815624793"
						     + "4379X1286"
						     + "629873514"
						     + "564192378"
						     + "381567942"
						     + "792348165";
	
	String sudokuInvalidLength = "978236451"
							   + "143785629"
							   + "256419837"
							   + "815624793"
							   + "4379X1286"
							   + "629873514"
							   + "564192378"
							   + "381567942"
							   + "7923481";
	
	String sudokuWrongGrid = "978236451"
						   + "143785629"
						   + "256419837"
						   + "815624793"
						   + "437951286"
						   + "629873514"
						   + "564192378"
						   + "381567942"
						   + "792348164";
	
	String sudokuWrongRow = "948236451"
			  			  + "173785629"
			  			  + "256419837"
			  			  + "815624793"
			  			  + "437951286"
			  			  + "629873514"
			  			  + "564192378"
			  			  + "381567942"
			  			  + "792348165";
	
	String sudokuWrongCol = "978236451"
						  + "413785629"
						  + "256419837"
						  + "815624793"
						  + "437951286"
						  + "629873514"
						  + "564192378"
						  + "381567942"
						  + "792348165";
	
	
	@Test( expected = InvalidLengthException.class)
	public void InvalidCharLength_Throws_Exception() throws InvalidLengthException{
		SudokuVerifier.verify(sudokuInvalidLength);
	}
	
	@Test
	public void correctSudoku_returns_0() throws InvalidLengthException{
		assertEquals(0,SudokuVerifier.verify(sudokuCorrecto));
	}
	
	@Test
	public void InvalidCharSudoku_returns_1() throws InvalidLengthException{
		assertEquals(-1,SudokuVerifier.verify(sudokuInvalidChar));
	}
	
	@Test
	public void WrongGridSudoku_returns_2() throws InvalidLengthException{
		assertEquals(-2,SudokuVerifier.verify(sudokuWrongGrid));
	}
	
	@Test
	public void WrongColSudoku_returns_3() throws InvalidLengthException{
		assertEquals(-3,SudokuVerifier.verify(sudokuWrongCol));
	}
	
	@Test
	public void WrongRowSudoku_returns_4() throws InvalidLengthException{
		assertEquals(-4,SudokuVerifier.verify(sudokuWrongRow));
	}
	

	
	
	
}
