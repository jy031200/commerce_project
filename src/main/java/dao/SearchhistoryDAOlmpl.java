package dao;

import dto.Searchhistory;

import java.util.List;

public interface SearchhistoryDAOlmpl {
   public void addSearchhistory(String user_id);
   public Searchhistory getSearchhistory(String user_id);
}
