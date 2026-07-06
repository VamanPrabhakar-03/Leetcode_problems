select b.contest_id,round(count(b.user_id) *100/ (select count(*) from Users a), 2) AS percentage from Register b
group by contest_id
order by percentage desc ,b.contest_id asc;
