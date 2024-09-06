package dao;

import dto.Searchhistory;

import java.util.List;

public interface SearchhistoryDAOlmpl {
   public void addSearchHistory(String id,String search);
   public Searchhistory getSearchhistory(String user_id);
}
