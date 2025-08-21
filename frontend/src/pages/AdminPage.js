import React, { useEffect, useState } from "react";

function AdminPage() {
  const [movies, setMovies] = useState([]);
  const [newVideo, setNewVideo] = useState({
    name: "",
    url: "",
    lengthOfVideo: "",
  });

  // Fetch all movies
  const fetchMovies = () => {
    fetch("http://localhost:8080/api/videos/admin")
      .then((res) => res.json())
      .then((data) => setMovies(data))
      .catch((err) => console.error(err));
  };

  useEffect(() => {
    fetchMovies();
  }, []);

  // Handle form input changes
  const handleChange = (e) => {
    setNewVideo({ ...newVideo, [e.target.name]: e.target.value });
  };

  // Add a new video
  const handleAddVideo = (e) => {
    e.preventDefault();

    fetch("http://localhost:8080/api/videos", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        name: newVideo.name,
        url: newVideo.url,
        lengthOfVideo: parseInt(newVideo.lengthOfVideo),
      }),
    })
      .then((res) => res.json())
      .then(() => {
        setNewVideo({ name: "", url: "", lengthOfVideo: "" });
        fetchMovies(); // refresh list
      })
      .catch((err) => console.error(err));
  };

  // Delete a video
  const handleDelete = (id) => {
    fetch(`http://localhost:8080/api/videos/${id}`, {
      method: "DELETE",
    })
      .then(() => fetchMovies())
      .catch((err) => console.error(err));
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>Admin Panel 🎬</h1>

      {/* Add Video Form */}
      <form onSubmit={handleAddVideo} style={{ marginBottom: "20px" }}>
        <input
          type="text"
          name="name"
          placeholder="Video Name"
          value={newVideo.name}
          onChange={handleChange}
          required
          style={{ marginRight: "10px" }}
        />
        <input
          type="text"
          name="url"
          placeholder="Video URL"
          value={newVideo.url}
          onChange={handleChange}
          required
          style={{ marginRight: "10px" }}
        />
        <input
          type="number"
          name="lengthOfVideo"
          placeholder="Length (min)"
          value={newVideo.lengthOfVideo}
          onChange={handleChange}
          required
          style={{ marginRight: "10px", width: "100px" }}
        />
        <button type="submit" style={{ padding: "6px 12px" }}>
          Add Video
        </button>
      </form>

      {/* List of Videos */}
      <ul style={{ listStyleType: "none", padding: 0 }}>
        {movies.map((movie) => (
          <li
            key={movie.id}
            style={{
              display: "flex",
              justifyContent: "space-between",
              alignItems: "center",
              marginBottom: "10px",
              padding: "10px",
              border: "1px solid #ccc",
              borderRadius: "8px",
              backgroundColor: "#f9f9f9",
            }}
          >
            <span>
              <strong>{movie.name}</strong> ({movie.lengthOfVideo} min)
            </span>
            <div>
              <button
                onClick={() => window.open(movie.url, "_blank")}
                style={{
                  marginRight: "10px",
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
              <button
                onClick={() => handleDelete(movie.id)}
                style={{
                  padding: "6px 12px",
                  backgroundColor: "#ff4d4f",
                  color: "white",
                  border: "none",
                  borderRadius: "5px",
                  cursor: "pointer",
                }}
              >
                🗑 Delete
              </button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default AdminPage;
