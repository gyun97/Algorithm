SELECT CATEGORY, SUM(SALES) TOTAL_SALES
FROM BOOK b JOIN BOOK_SALES s ON b.BOOK_ID = s.BOOK_ID
WHERE DATE_FORMAT(SALES_DATE, '%Y-%m') LIKE '%2022-01%'
GROUP BY CATEGORY
ORDER BY CATEGORY;