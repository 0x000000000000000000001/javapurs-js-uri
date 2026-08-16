try {
  decodeURIComponent("\udc00");
} catch(e) {
  console.log("decodeURIComponent lone surrogate:", e.name);
}
