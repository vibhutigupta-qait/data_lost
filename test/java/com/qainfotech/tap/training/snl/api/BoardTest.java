package com.qainfotech.tap.training.snl.api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class BoardTest {
	Board board;
  @BeforeMethod
  public void beforeMethod() throws FileNotFoundException, UnsupportedEncodingException, IOException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption {
	  board = new Board();
	  board.registerPlayer("vibhutigupta");
  }

  @AfterMethod
  public void afterMethod() {
  }


  @Test
  public void Board() {
    //throw new RuntimeException("Test not implemented");
	  
  }

  @Test
  public void BoardUUID() {
    throw new RuntimeException("Test not implemented");
  }

  
  @Test(expectedExceptions = MaxPlayersReachedExeption.class)
  public void MaxPlayersReached() throws FileNotFoundException, UnsupportedEncodingException, IOException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption{
	  board = new Board();
	  board.registerPlayer("vibhutigupta");
	     board.registerPlayer("vanika");
	  	 board.registerPlayer("varsha");
	  	 board.registerPlayer("abc");
	  	 board.registerPlayer("def");
	  	 Assert.assertEquals(board.getData().getJSONArray("players").length(), 4);
	  
  }
  
  
  

  @Test(expectedExceptions = GameInProgressException.class)
  public void GameInProgress() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException {
	     board = new Board();
	     board.registerPlayer("vibhutigupta");
	     board.registerPlayer("vanika");
	  	 board.registerPlayer("varsha");
	  	 board.registerPlayer("abc");
	  	
	  	 Assert.assertEquals(board.getData().getJSONArray("players").getJSONObject(0).get("position").equals("1"),true);
	  
  }
  
  
  @Test
  public void deletePlayer() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException, NoUserWithSuchUUIDException {
    //throw new RuntimeException("Test not implemented");
	  board = new Board();
	  
	 board.registerPlayer("vibhutigupta");
     board.registerPlayer("vanika");
  	 board.registerPlayer("varsha");
  	 board.registerPlayer("abc");
  	 
  	 UUID u = (UUID) board.getData().getJSONArray("players").getJSONObject(0).get("uuid");
  	Assert.assertEquals(board.getData().getJSONArray("players").getJSONObject(0).get("uuid").equals(u), true);
  	board.deletePlayer(u);
  	
  }
  
  

  @Test
  public void getData() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getUUID() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void registerPlayer() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException {
    //throw new RuntimeException("Test not implemented");
	  board = new Board();
	  board.registerPlayer("vibhutigupta");
      board.registerPlayer("vanika");
  	  board.registerPlayer("varsha");
  	  board.registerPlayer("abc");
	  Assert.assertEquals(board.getData().getJSONArray("players").length(), 4);
	 
	  Assert.assertEquals(board.getData().getJSONArray("players").getJSONObject(0).get("name").equals("vibhutigupta"), true);
	
	  //Assert.assertEquals(board.getData().getJSONArray("players").getJSONObject(0).get(""), true);
	   }

  @Test
  public void rollDice() throws FileNotFoundException, UnsupportedEncodingException, IOException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, JSONException, InvalidTurnException {
	  board = new Board();
	  board.registerPlayer("vibhutigupta");
      board.registerPlayer("vanika");
  	  board.registerPlayer("varsha");
  	  board.registerPlayer("abc");
  	  
  	 UUID u = (UUID) board.getData().getJSONArray("players").getJSONObject(0).get("uuid");
  	 Integer turn = (Integer) board.getData().getJSONArray("players").getJSONObject(0).get("turn");
     Integer pos = (Integer) board.data.getJSONArray("players").getJSONObject(turn).get("position");
     Integer dice = board.rollDice(u).getInt("dice");
     //Integer newpos = pos+dice;
     Assert.assertEquals(board.data.getJSONArray("steps").getJSONObject(0).get("type"), 0);
     
     
     
     
     
     
    
     
     
     
     
     
     
     
     
     
  	//Assert.assertEquals(board.getData().getJSONArray("players").getJSONObject(turn).get("uuid").equals(u),true);
  	 
  	// Integer position = board.getData()
  	  
  	  
	  
	  
    //throw new RuntimeException("Test not implemented");
	 
	  
  }

 // @Test
  //public String toString() {
    //throw new RuntimeException("Test not implemented");
    
  //}
}
