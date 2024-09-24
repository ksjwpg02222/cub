# CUB 作業

## 開發要求
* Java 8
* 資料庫：H2（OpenJPA / Spring Data JPA）
* Maven

## 功能簡述
* 串接第三方API，解析其內容與資料轉換，並實作新的API
* 建立一張Table並實作基本CRUD

## 測試概述
* TestCase1 -> 測試呼叫查詢API並顯示內容(顯示全部)
* TestCase2 -> 測試呼叫新增API後並顯示內容(顯示全部)
* TestCase3 -> 測試呼叫更新API後並顯示內容(顯示全部)
* TestCase4 -> 測試呼叫刪除API後並顯示內容(顯示全部)
* TestCase5 -> 測試呼叫第三方API後並顯示內容(未將訊息優化)
* TestCase6 -> 測試呼叫第三方API後並轉換內容顯示