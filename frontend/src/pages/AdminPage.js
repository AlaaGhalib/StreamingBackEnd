import React, { useEffect, useState } from "react";

function AdminPage() {
  const [movies, setMovies] = useState([]);
  const [newVideo, setNewVideo] = useState({ name: "", url: "", lengthOfVideo: "" });
  const [selectedVideo, setSelectedVideo] = useState(null);

  const fetchMovies = () => {
    fetch("http://localhost:8080/api/videos/admin")
      .then(res => res.json())
      .then(data => setMovies(data))
      .catch(err => console.error(err));
  };

  useEffect(() => fetchMovies(), []);

  const handleAddVideo = e => {
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
      .then(() => {
        setNewVideo({ name: "", url: "", lengthOfVideo: "" });
        fetchMovies();
      })
      .catch(err => console.error(err));
  };

  const handleDelete = id => {
    fetch(`http://localhost:8080/api/videos/${id}`, { method: "DELETE" })
      .then(() => {
        if (selectedVideo?.id === id) setSelectedVideo(null);
        fetchMovies();
      })
      .catch(err => console.error(err));
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
          onChange={e => setNewVideo({ ...newVideo, name: e.target.value })}
          required
          style={{ marginRight: "10px" }}
        />
        <input
          type="text"
          name="url"
          placeholder="Video URL (e.g., /videos/movie.mp4)"
          value={newVideo.url}
          onChange={e => setNewVideo({ ...newVideo, url: e.target.value })}
          required
          style={{ marginRight: "10px" }}
        />
        <input
          type="number"
          name="lengthOfVideo"
          placeholder="Length (min)"
          value={newVideo.lengthOfVideo}
          onChange={e => setNewVideo({ ...newVideo, lengthOfVideo: e.target.value })}
          required
          style={{ marginRight: "10px", width: "100px" }}
        />
        <button type="submit">Add Video</button>
      </form>

      {/* Video List */}
      <ul style={{ listStyleType: "none", padding: 0 }}>
        {movies.map(movie => (
          <li key={movie.id} style={{ marginBottom: "10px" }}>
            <strong>{movie.name}</strong> ({movie.lengthOfVideo} min)
            <button onClick={() => setSelectedVideo(movie)} style={{ marginLeft: "10px" }}>
              ▶ Play
            </button>
            <button onClick={() => handleDelete(movie.id)} style={{ marginLeft: "5px" }}>
              🗑 Delete
            </button>
          </li>
        ))}
      </ul>

      {/* Inline Video Player */}
      {selectedVideo && (
        <div style={{ marginTop: "20px" }}>
          <h2>Now Playing: {selectedVideo.name}</h2>
          <video width="640" height="360" controls>
            <source src={selectedVideo.url} type="video/mp4" />
            Your browser does not support the video tag.
          </video>
        </div>
      )}
    </div>
  );
}

export default AdminPage;
