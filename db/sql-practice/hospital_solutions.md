# Practicas de MySQL

Solución a los ejercicios de [https://www.practice-sql.com](https://www.practice-sql.com/)

# Hospital database
# EASY LEVEL 
## 1. Show first name, last name, and gender of patients whose gender is 'M'
~~~sql
SELECT first_name, last_name, gender 
FROM patients
where gender = 'M';
~~~
## 2. Show first name and last name of patients who does not have allergies. (null)
~~~sql
SELECT first_name, last_name
FROM patients
where allergies IS NULL;
~~~
## 3. Show first name of patients that start with the letter 'C'
~~~sql
SELECT first_name 
FROM patients
where first_name LIKE 'C%';
~~~
## 4. Show first name and last name of patients that weight within the range of 100 to 120 (inclusive)
~~~sql
SELECT first_name, last_name 
FROM patients
where weight between 100 And 120;
~~~
## 5. Update the patients table for the allergies column. If the patient's allergies is null then replace it with 'NKA'
~~~sql
update patients
SET allergies = 'NKA'
where allergies Is null;
~~~
## 6. Show first name and last name concatinated into one column to show their full name.
~~~sql
SELECT CONCAT(first_name,  ' ', last_name) AS full_name
FROM patients;
~~~
## 7. Show first name, last name, and the full province name of each patient. Example: 'Ontario' instead of 'ON'
~~~sql
SELECT p.first_name, p.last_name, pn.province_name
FROM patients p
LEFT JOIN province_names pn ON p.province_id = pn.province_id;
~~~
## 8. Show how many patients have a birth_date with 2010 as the birth year.
~~~sql
SELECT COUNT(p.patient_id) AS total_patients
FROM patients p
WHERE YEAR(p.birth_date) = 2010;
~~~
## 9. Show the first_name, last_name, and height of the patient with the greatest height.
~~~sql
SELECT p.first_name, p.last_name, MAX(p.height) AS height
FROM patients p;
~~~
~~~sql
SELECT p.first_name, p.last_name, MAX(p.height) AS height
FROM patients p
ORDER BY p.height DESC LIMIT 1;
~~~
## 10. Show all columns for patients who have one of the following patient_ids: 1,45,534,879,1000
~~~sql
SELECT *
FROM patients p
WHERE p.patient_id IN (1, 45, 534, 879, 1000);
~~~
## 11. Show the total number of admissions
~~~sql
SELECT COUNT(a.patient_id)
FROM admissions a;
~~~
## 12. Show all the columns from admissions where the patient was admitted and discharged on the same day.
~~~sql
SELECT *
FROM admissions a
WHERE a.admission_date = a.discharge_date;
~~~
## 13. Show the patient id and the total number of admissions for patient_id 579.
~~~sql
SELECT a.patient_id, COUNT(a.patient_id) AS total_admissions
FROM admissions a
WHERE a.patient_id = 579;
~~~
## 14. Based on the cities that our patients live in, show unique cities that are in province_id 'NS'?
~~~sql
SELECT DISTINCT p.city
FROM patients p
WHERE p.province_id = 'NS';
~~~
## 15. Write a query to find the first_name, last name and birth date of patients who has height greater than 160 and weight greater than 70
~~~sql
SELECT p.first_name, p.last_name, p.birth_date
FROM patients p
WHERE p.height > 160 AND p.weight > 70;
~~~
## 16. Write a query to find list of patients first_name, last_name, and allergies where allergies are not null and are from the city of 'Hamilton'
~~~sql
SELECT p.first_name, p.last_name, p.allergies
FROM patients p
WHERE p.allergies IS NOT NULL AND p.city = 'Hamilton';
~~~
## 17. Show unique birth years from patients and order them by ascending.
~~~sql
SELECT DISTINCT YEAR(p.birth_date) AS birth_year
FROM patients p
ORDER BY birth_year ASC;
~~~
## 18. Show unique first names from the patients table which only occurs once in the list.
  
  For example, if two or more people are named 'John' in the first_name column then don't include their name in the output list. If only 1 person is named 'Leo' then include them in the output.
~~~sql
SELECT DISTINCT p.first_name
FROM patients p
GROUP BY p.first_name
HAVING COUNT(p.first_name) = 1;
~~~
## 19. Show patient_id and first_name from patients where their first_name start and ends with 's' and is at least 6 characters long.
~~~sql
SELECT p.patient_id, p.first_name
FROM patients p
WHERE p.first_name LIKE '%s' 
	AND p.first_name LIKE 's%' 
    AND LENGTH(p.first_name) >= 6;
~~~
~~~sql
SELECT patient_id, first_name
FROM patients
WHERE first_name LIKE 's%s'
    AND len(first_name) >= 6;
~~~
## 20. Show patient_id, first_name, last_name from patients whos diagnosis is 'Dementia'.
    Primary diagnosis is stored in the admissions table.
~~~sql
SELECT p.patient_id, p.first_name, p.last_name
FROM patients p
LEFT JOIN admissions a ON p.patient_id = a.patient_id
WHERE a.diagnosis = 'Dementia';
~~~
## 21. Display every patient's first_name. Order the list by the length of each name and then by alphabetically.
~~~sql
SELECT p.first_name
FROM patients p
ORDER BY LENGTH(p.first_name), first_name ASC;
~~~
## 22. Show the total amount of male patients and the total amount of female patients in the patients table. Display the two results in the same row.
~~~sql
SELECT
    SUM(CASE WHEN p.gender = 'M' THEN 1 ELSE 0 END) AS male_count,
    SUM(CASE WHEN p.gender = 'F' THEN 1 ELSE 0 END) AS female_count
FROM patients p;
~~~
## 23. Show first and last name, allergies from patients which have allergies to either 'Penicillin' or 'Morphine'. Show results ordered ascending by allergies then by first_name then by last_name.
~~~sql
SELECT p.first_name, p.last_name, p.allergies
FROM patients p 
WHERE p.allergies IN ('Penicillin', 'Morphine')
ORDER BY p.allergies, first_name, last_name;
~~~
## 24. Show patient_id, diagnosis from admissions. Find patients admitted multiple times for the same diagnosis.
~~~sql
SELECT patient_id, diagnosis
FROM admissions
GROUP BY patient_id, diagnosis
HAVING COUNT(patient_id) > 1;
~~~
## 25. Show the city and the total number of patients in the city. Order from most to least patients and then by city name ascending.
~~~sql
SELECT city, COUNT(patient_id) AS total_patients
FROM patients
GROUP BY city
ORDER BY total_patients DESC, city;
~~~
## 26. Show first name, last name and role of every person that is either patient or doctor. The roles are either "Patient" or "Doctor"
~~~sql
SELECT first_name, last_name, 'Patient'
FROM patients
UNION ALL
SELECT first_name, last_name, 'Doctor'
FROM doctors;
~~~
## 27. Show all allergies ordered by popularity. Remove NULL values from query.
~~~sql
SELECT allergies, count(allergies) AS popularity
FROM patients
WHERE allergies IS NOT NULL
GROUP BY allergies
ORDER BY COUNT(allergies) DESC;
~~~
## 28. Show all patient's first_name, last_name, and birth_date who were born in the 1970s decade. Sort the list starting from the earliest birth_date.
~~~sql
SELECT first_name, last_name, birth_date
FROM patients
WHERE birth_date between '1970-01-01' AND '1979-12-31'
ORDER BY birth_date ASC;
~~~
~~~sql
SELECT
  first_name,
  last_name,
  birth_date
FROM patients
WHERE year(birth_date) LIKE '197%'
ORDER BY birth_date ASC
~~~
## 29. We want to display each patient's full name in a single column. Their last_name in all upper letters must appear first, then first_name in all lower case letters. Separate the last_name and first_name with a comma. Order the list by the first_name in decending order. EX: SMITH,jane
~~~sql
SELECT CONCAT(UPPER(last_name), ',', LOWER(first_name)) AS full_name
FROM patients
ORDER BY first_name DESC;
~~~
## 30. Show the province_id(s), sum of height; where the total sum of its patient's height is greater than or equal to 7,000.
~~~sql
SELECT province_id, SUM(height) AS sum_height
FROM patients
GROUP BY province_id
HAVING sum_height >= 7000;
~~~
## 31. Show the difference between the largest weight and smallest weight for patients with the last name 'Maroni'
~~~sql
SELECT (MAX(weight) - MIN(weight)) AS diff_weight
FROM patients
WHERE last_name = 'Maroni';
~~~
## 32. Show all of the days of the month (1-31) and how many admission_dates occurred on that day. Sort by the day with most admissions to least admissions.
~~~sql
SELECT DAY(admission_date) AS month_day, COUNT(admission_date) AS total_admissions
FROM admissions
GROUP BY month_day
ORDER BY total_admissions DESC;
~~~
## 33. Show all columns for patient_id 542's most recent admission_date.
~~~sql
SELECT *
FROM admissions
WHERE patient_id = 542 
GROUP BY patient_id
HAVING MAX(admission_date);
~~~
## 34. Show patient_id, attending_doctor_id, and diagnosis for admissions that match one of the two criteria:
    1. patient_id is an odd number and attending_doctor_id is either 1, 5, or 19.
    2. attending_doctor_id contains a 2 and the length of patient_id is 3 characters.
~~~sql
SELECT patient_id, attending_doctor_id, diagnosis
FROM admissions
WHERE attending_doctor_id LIKE '%2%' AND LENGTH(patient_id) = 3
	OR MOD(patient_id, 2) <> 0 AND attending_doctor_id IN (1, 5,19);
~~~
## 35. Show first_name, last_name, and the total number of admissions attended for each doctor. Every admission has been attended by a doctor.
~~~sql
SELECT first_name, last_name, COUNT(admission_date) AS admissions_total
FROM admissions a
JOIN doctors p ON p.doctor_id = a.attending_doctor_id
WHERE a.attending_doctor_id IS NOT NULL
GROUP BY a.attending_doctor_id;
~~~
## 36. For each doctor, display their id, full name, and the first and last admission date they attended.
~~~sql
SELECT 
    d.doctor_id, 
    CONCAT(first_name, ' ', last_name), 
    MIN(a.admission_date) AS first_admission_date, 
    MAX(a.admission_date) AS last_admission_date
FROM admissions a
JOIN doctors d ON d.doctor_id = a.attending_doctor_id
GROUP BY d.doctor_id;
~~~
## 37. Display the total amount of patients for each province. Order by descending.
~~~sql
SELECT province_name, COUNT(patient_id) AS total_patients
FROM patients p
LEFT JOIN province_names pn ON p.province_id = pn.province_id
GROUP BY p.province_id
ORDER BY total_patients DESC;
~~~
## 38. For every admission, display the patient's full name, their admission diagnosis, and their doctor's full name who diagnosed their problem.
~~~sql
SELECT 
	CONCAT(p.first_name, ' ', p.last_name) AS patient_name, 
    a.diagnosis, 
    CONCAT(d.first_name, ' ', d.last_name) AS doctor_name
FROM admissions a
LEFT JOIN patients p ON p.patient_id = a.patient_id
LEFT JOIN doctors d ON a.attending_doctor_id = d.doctor_id;
~~~
## 39. Display the first name, last name and number of duplicate patients based on their first name and last name.
    Ex: A patient with an identical name can be considered a duplicate.
~~~sql
SELECT 
    p.first_name, 
    p.last_name, 
    COUNT(CONCAT(p.first_name, ' ', p.last_name)) AS duplicate_names
FROM patients p 
GROUP BY p.first_name, p.last_name
HAVING duplicate_names > 1;
~~~
## 40. Display patient's full name, height in the units feet rounded to 1 decimal, weight in the unit pounds rounded to 0 decimals, birth_date, gender non abbreviated.
    Convert CM to feet by dividing by 30.48.
    Convert KG to pounds by multiplying by 2.205.
~~~sql
SELECT 
	CONCAT(p.first_name, ' ', p.last_name) AS full_name, 
	ROUND(p.height / 30.48, 1) AS 'height "feet"',
    FLOOR(p.weight * 2.205) AS 'weight "pound"',
    p.birth_date,
    CASE
    	WHEN gender = 'M' THEN 'Male'
        ELSE 'Female'
    END AS gender
FROM patients p; 
~~~
## 
~~~sql

~~~
## 
~~~sql

~~~
## 
~~~sql

~~~
## 
~~~sql

~~~
## 
~~~sql

~~~
## 
~~~sql

~~~
## 
~~~sql

~~~
## 
~~~sql

~~~
## 
~~~sql

~~~
## 
~~~sql

~~~
## 
~~~sql

~~~
## 
~~~sql

~~~
## 
~~~sql

~~~
## 
~~~sql

~~~
## 
~~~sql

~~~
## 
~~~sql

~~~