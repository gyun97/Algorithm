-- 코드를 입력하세요
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, COALESCE(freezer_yn, 'N') AS FREEZER_YN from food_warehouse WHERE ADDRESS LIKE '경기%'ORDER BY warehouse_id;