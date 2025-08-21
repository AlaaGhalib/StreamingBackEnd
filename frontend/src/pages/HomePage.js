import React, { useEffect, useState } from "react";

function HomePage() {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/videos/admin") // adjust if backend is on a different port
      .then((response) => response.json())
      .then((data) => setMovies(data))
      .catch((error) => console.error("Error fetching movies:", error));
  }, []);
  const handlePlay = (movie) => {
    window.open(movie.url, "_blank");;;;;;;;;;;;;;;;;;;
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>Movies 🎬</h1>
      <ul style={{ listStyleType: "none", padding: 0 }}>
        {movies.map((movie) => (
          <li
            key={movie.id}
            style={{
              display: "flex",
              justifyContent: "space-between",
              alignItems: "center",
              marginBottom: "12px",
              padding: "10px",
              border: "1px solid #ccc",
              borderRadius: "8px",
              backgroundColor: "#f9f9f9",
            }}
          >
            <span>
              <strong>{movie.name}</strong> ({movie.lengthOfVideo} min)
            </span>
            <button
              onClick={() => handlePlay(movie)}
              style={{
                padding: "6px 12px",
                backgroundColor: "#1e90ff",
                color: "white",
                border: "none",
                borderRadius: "5px",
                cursor: "pointer",
              }}
            >
              ▶ Play
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default HomePage;
